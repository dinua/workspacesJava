package com.medweb.ui.table;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.medweb.ui.help.ImageID;
import com.medweb.ui.help.WidgetFactory;

public class EditTableViewer {
	private Color color=new Color(Display.getCurrent(),238,218,185 );
	private Color colorRed=new Color(Display.getCurrent(),255,10,10 );
	private Composite composite;
	private int searchHeight=250;
	private List<ColumnDescriptor> columnDescriptors;
	private List<Object> inputObject;
	private TableViewer tableViewer;
	private Button button;
	private ComboViewer columnComboViewer;
	private ComboViewer criteriaComboViewer;
	private Text text;
	private Button buttonViewFilters;
	private Label infoFilter1;
	private int difSize;
	private boolean space;
	private boolean noFilter;
	
	 public	EditTableViewer(Composite parent,int style,List<ColumnDescriptor> 
	                                        columnDescriptors,List<Object> inputObject) {
		 super();
		this.columnDescriptors=columnDescriptors;
		this.inputObject=inputObject;
		 createTableView(parent, style);
			
		}
	 
	 public	EditTableViewer(Composite parent,int style,List<ColumnDescriptor> 
                                        columnDescriptors,List<Object> inputObject,int difSize) {
                super();
		        this.columnDescriptors=columnDescriptors;
                this.inputObject=inputObject;
                this.difSize=difSize;
                createTableView(parent, style);
	 }
	 public	EditTableViewer(Composite parent,int style,List<ColumnDescriptor> 
     columnDescriptors,List<Object> inputObject,int difSize,boolean space) {
		 super();
		 this.columnDescriptors=columnDescriptors;
		 this.inputObject=inputObject;
		 this.difSize=difSize;
		 this.space=space;
		 createTableView(parent, style);
}
	 public	EditTableViewer(Composite parent,int style,List<ColumnDescriptor> 
     columnDescriptors,List<Object> inputObject,int difSize,boolean space,boolean noFilter) {
		 super();
		 this.columnDescriptors=columnDescriptors;
		 this.inputObject=inputObject;
		 this.difSize=difSize;
		 this.space=space;
		 this.noFilter=noFilter;
		 createTableView(parent, style);
}
	private void createTableView(Composite parent,int style){
		int windowHeight=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getSize().y;
		
		TableLayout tableLayout = new TableLayout();
	    composite=new Composite(parent, style);
	    GridData cdata=new GridData(SWT.FILL,SWT.FILL,false,true,1,1);
	    cdata.widthHint=500;
	    composite.setLayoutData(cdata);
	    
	    Table exampleTable = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL |SWT.H_SCROLL);
	    exampleTable.setLinesVisible(true);
	  
	    exampleTable.setHeaderVisible(true);
	   exampleTable.setBackground(color);
	    
	   setTableViewer(new TableViewer(exampleTable));
	   GridData dataTW=new GridData(SWT.FILL, SWT.TOP, true, true);
	 	dataTW.heightHint=windowHeight-searchHeight-difSize;
	    getTableViewer().getControl().setLayoutData(dataTW);
	   
	    tableLayout.addColumnData(new ColumnWeightData(15));
	    TableViewerColumn indexColumn = new TableViewerColumn(getTableViewer(), SWT.None);
	    indexColumn.getColumn().setText("#");
	
	  Iterator<ColumnDescriptor> it=columnDescriptors.iterator();

	 while(it.hasNext()){
	 	 ColumnDescriptor column=it.next();
	 	 if(column.getWeight()>0){
	 	  tableLayout.addColumnData(new ColumnWeightData(column.getWeight()));
	 	 }
	 	 else{
	 		 tableLayout.addColumnData(new ColumnWeightData(100));
	 	 }
	 	 
	 TableViewerColumn labelColumn = new TableViewerColumn(getTableViewer(), SWT.None);
	 labelColumn.getColumn().setText(column.getColumnName());
	 //if(column.isEditableColumn()){
	     labelColumn.setEditingSupport(new EditingColumn(tableViewer,column.getColumnName(),column.isEditableColumn()));
      // }
	 changeColumnType(labelColumn, column);
	
	  }

	  exampleTable.setLayout(tableLayout);
	  getTableViewer().setContentProvider(new ArrayContentProvider());
	  
	  getTableViewer().setLabelProvider(new TableLabelProvider(columnDescriptors)); 
	 int columnHeight=30;
	 int aux=(windowHeight-searchHeight)- inputObject.size()*columnHeight;
	 int n=(int)aux/columnHeight;

	 if(n>0){
	     for(int i=0;i<n;i++){ 
	           inputObject.add(new Object());
	     }
	 }
	  getTableViewer().setInput(inputObject);

//######################################################################
//##############search composite ######################################
//####################################################################	  
	if(!noFilter){
	  Group searchComposite=new Group(composite, SWT.V_SCROLL | SWT.H_SCROLL);
	  searchComposite.setLayout(new GridLayout(8,true));
      GridData dataSearch=new GridData(SWT.FILL, SWT.FILL, true, true);
	  dataSearch.heightHint=searchHeight;
	  searchComposite.setLayoutData(dataSearch);
	  searchComposite.setText("Filter");
		 createSearchComposite(searchComposite);
	 
	createListeners();
	}
	}
	
 private void createSearchComposite(Group searchComposite){
	 Label columnLabel=WidgetFactory.createLabel(searchComposite, "columnLabel",TableMessages.EDIT_COLUMN.getMessage());
	 columnLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));

	 Label criteriaLabel=WidgetFactory.createLabel(searchComposite, "criteriaLabel",TableMessages.EDIT_CRITERIA.getMessage());
	 criteriaLabel.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));

	 for(int i=0;i<6;i++){
	 	Label label=WidgetFactory.createLabel(searchComposite, "");
	 	label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
	 }

	 columnComboViewer = WidgetFactory.createComboViewer(searchComposite, "columnComboViewer", false);
	 criteriaComboViewer = WidgetFactory.createComboViewer(searchComposite, "criteriaComboViewer", false);
	 
	 text = WidgetFactory.createText(searchComposite, "text", 100, false);
	 text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,2,1));
	
	 button = WidgetFactory.createButton(searchComposite, "button", 
			       TableMessages.EDIT_ADD.getMessage(), false,ImageID.IMAGE_ADD_OBJ);
	 GridData buttonData=new GridData(SWT.RIGHT, SWT.FILL, true, false,1,1);
	 buttonData.widthHint=50;
	 button.setLayoutData(buttonData);
	 
	

	Iterator<ColumnDescriptor> it=columnDescriptors.iterator();

	 while(it.hasNext()){
	 	 ColumnDescriptor column=it.next();
	 	 columnComboViewer.add(column.getColumnName());
	 }
	 criteriaComboViewer.add(CriteriaType.CRITERIA_IS.toString());
	 criteriaComboViewer.add(CriteriaType.CRITERIA_LIKE.toString());
	 criteriaComboViewer.add(CriteriaType.CRITERIA_NOT.toString());
	if(!space) 
	 for(int i=0;i<2;i++){
			Label label=WidgetFactory.createLabel(searchComposite, "");
			label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		}
	 buttonViewFilters = WidgetFactory.createButton(searchComposite, "buttonViewFilters",
			             TableMessages.EDIT_FILTERS.getMessage(), false,ImageID.IMAGE_ROSOURCE_HISTORY);
	 GridData buttFilterData=new GridData(SWT.LEFT, SWT.FILL, true, false,1,1);
	 buttFilterData.widthHint=75;
	 buttonViewFilters.setLayoutData(buttFilterData);
	
	 for(int i=0;i<6;i++){
		 	Label label=WidgetFactory.createLabel(searchComposite, "");
		 	label.setLayoutData(new GridData(SWT.FILL,SWT.BOTTOM,true,false,1,1));
		 }
	 
	 infoFilter1 = WidgetFactory.createLabel(searchComposite, "infoFilter1",TableMessages.EDIT_NR_OF_FILTERS_TEXT.getMessage()+tableViewer.getFilters().length);
	 GridData infoData=new GridData(SWT.RIGHT,SWT.FILL,true,false,2,1);
	 infoData.widthHint=140;
	 infoFilter1.setLayoutData(infoData);
	 infoFilter1.setForeground(colorRed);
    
 }
 	
 private void changeColumnType( TableViewerColumn labelColumn, ColumnDescriptor column){
	
	 ColumnType columnType=column.getColumnType();
	 if(columnType.equals(ColumnType.COLUMN_COMBO))
	 {
	 String[]s={"da","nu"};
	 EditingSupport editingSupport = new ComboEditingSupport(labelColumn.getViewer(),column.getColumnName(),s);
	 labelColumn.setEditingSupport(editingSupport);
	 }
 }

 private void createListeners(){
	 TableFilterAction tableFilterAction=new TableFilterAction();
	 tableFilterAction.setColumnViewer(columnComboViewer);
	 tableFilterAction.setCriteriaViewer(criteriaComboViewer);
	 tableFilterAction.setTableViewer(getTableViewer());
	 tableFilterAction.setTextt(text);
	 tableFilterAction.setInfoLabel(infoFilter1); 
	
	 
	 button.addListener(SWT.Selection, tableFilterAction);
	 
	 TableViewFiltersAction tableViewFilterAction=new TableViewFiltersAction(tableViewer);
	 tableViewFilterAction.setInfoLabel(infoFilter1);

	 buttonViewFilters.addListener(SWT.Selection, tableViewFilterAction);
 }
 
/**
 * @return the tableViewer
 */
public TableViewer getTableViewer() {
	return tableViewer;
}

/**
 * @param tableViewer the tableViewer to set
 */
public void setTableViewer(TableViewer tableViewer) {
	this.tableViewer = tableViewer;
}
/**
 * @return the composite
 */
public Composite getComposite() {
	return composite;
}
}
