package com.medweb.ui.table;

	import org.eclipse.jface.viewers.CellEditor;
	import org.eclipse.jface.viewers.EditingSupport;
	import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;


	@SuppressWarnings("serial")
	public class EditingColumn extends EditingSupport {

		private final TableViewer viewer;
        private final String columnName;
        private final boolean editable;
		public EditingColumn(TableViewer viewer,String columnName,boolean editable) {
			super(viewer);
			this.viewer = viewer;
			this.columnName=columnName;
			this.editable=editable;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return new TextCellEditor(viewer.getTable());
		}

		@Override
		protected boolean canEdit(Object element) {
			return editable;
		}

		@Override
		protected Object getValue(Object element) {
			ClassType classType=new ClassType(element, columnName);
			TableLabelProvider.index=0;
			return classType.getValue();
		}

		@Override
		protected void setValue(Object element, Object value) {		
				new ClassType(element, columnName,value.toString());
				viewer.refresh();
			
		}
	}

