package com.medweb.ui.menu;

import java.util.ArrayList;

import medweb.psconf.daos.UserType;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.medweb.ui.help.ApplicationMenuID;
import com.medweb.ui.medic.MedicModel;

/**
 * View with a tree viewer. This class is contributed through the plugin.xml.
 */
public class NavigationView extends ViewPart {
	public static final String ID = "com.medweb.ui.menu.navigationView";
	private TreeViewer viewer;
	private MedicModel medicModel;
   
	class TreeObject {
		private String name;
		private TreeParent parent;
		
		public TreeObject(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public String toString() {
			return getName();
		}
	}

	class TreeParent extends TreeObject {
		private ArrayList<TreeObject> children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList<TreeObject>();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject[] getChildren() {
			return (TreeObject[]) children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}

	@SuppressWarnings("serial")
	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}

		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}

		public Object[] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}

		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
	}

	@SuppressWarnings("serial")
	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			//String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			String imageKey = ISharedImages.IMG_OBJ_FILE;
			if (obj instanceof TreeParent)
			 imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
  
	private TreeObject createAdminMenu(){
		TreeParent root = new TreeParent("");
		TreeParent p5=new TreeParent(ApplicationMenuID.FOLDER_NAME5.toString());
		//...................Menu5..................................
				TreeObject p5to1=new TreeObject(ApplicationMenuID.FILE_ADMINISTRARE1.toString());
				TreeObject p5to2=new TreeObject(ApplicationMenuID.FILE_ADMINISTRARE2.toString());
				TreeObject p5to3=new TreeObject(ApplicationMenuID.FILE_ADMINISTRARE3.toString());
				
				p5.addChild(p5to1);
				p5.addChild(p5to2);
				p5.addChild(p5to3);
				
				root.addChild(p5);
				
				return root;
	}
	
	private TreeObject createMedicMenu(){
		TreeParent root = new TreeParent("");
		TreeParent p1=new TreeParent(ApplicationMenuID.FOLDER_NAME1.toString());
		TreeParent p2=new TreeParent(ApplicationMenuID.FOLDER_NAME2.toString());
		TreeParent p4=new TreeParent(ApplicationMenuID.FOLDER_NAME4.toString());
		
		//...................Menu1..................................
				TreeObject p1to1=new TreeObject(ApplicationMenuID.FILE_MEDIC1.toString());
				TreeObject p1to2=new TreeObject(ApplicationMenuID.FILE_MEDIC2.toString());
				TreeObject p1to3=new TreeObject(ApplicationMenuID.FILE_MEDIC3.toString());
				TreeObject p1to4=new TreeObject(ApplicationMenuID.FILE_MEDIC4.toString());
				
				p1.addChild(p1to1);
				p1.addChild(p1to2);
				p1.addChild(p1to3);
				p1.addChild(p1to4);
				
				//...................Menu2..................................
				TreeObject p2to1=new TreeObject(ApplicationMenuID.FILE_PATIENT1.toString());
				TreeObject p2to2=new TreeObject(ApplicationMenuID.FILE_PATIENT2.toString());
				TreeObject p2to3=new TreeObject(ApplicationMenuID.FILE_PATIENT3.toString());
				TreeObject p2to4=new TreeObject(ApplicationMenuID.FILE_PACIENT4.toString());
					
				p2.addChild(p2to1);
				p2.addChild(p2to2);
				p2.addChild(p2to3);
				p2.addChild(p2to4);
				//...................Menu3..................................
				
				//...................Menu4..................................
				TreeObject p4to1=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE1.toString());
				TreeObject p4to2=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE2.toString());
				TreeObject p4to3=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE3.toString());
				TreeObject p4to4=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE4.toString());
				TreeObject p4to5=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE5.toString());
				
				
				p4.addChild(p4to1);
				p4.addChild(p4to2);
				p4.addChild(p4to3);
				p4.addChild(p4to4);
				p4.addChild(p4to5);
		
				root.addChild(p1);
				root.addChild(p2);
				root.addChild(p4);
				
		return root;
	}
	
	private TreeObject createAsistentMenu(){
		TreeParent root = new TreeParent("");
		TreeParent p1=new TreeParent(ApplicationMenuID.FOLDER_NAME1.toString());
		TreeParent p2=new TreeParent(ApplicationMenuID.FOLDER_NAME2.toString());
		TreeParent p4=new TreeParent(ApplicationMenuID.FOLDER_NAME4.toString());
		
		//...................Menu1..................................
				TreeObject p1to1=new TreeObject(ApplicationMenuID.FILE_MEDIC1.toString());
				TreeObject p1to2=new TreeObject(ApplicationMenuID.FILE_MEDIC2.toString());
				TreeObject p1to3=new TreeObject(ApplicationMenuID.FILE_MEDIC3.toString());
				TreeObject p1to4=new TreeObject(ApplicationMenuID.FILE_MEDIC4.toString());
				
				p1.addChild(p1to1);
				p1.addChild(p1to2);
				p1.addChild(p1to3);
				p1.addChild(p1to4);
				
				//...................Menu2..................................
				TreeObject p2to1=new TreeObject(ApplicationMenuID.FILE_PATIENT1.toString());
				TreeObject p2to2=new TreeObject(ApplicationMenuID.FILE_PATIENT2.toString());
				//TreeObject p2to3=new TreeObject(ApplicationMenuID.FILE_PATIENT3.toString());
				TreeObject p2to4=new TreeObject(ApplicationMenuID.FILE_PACIENT4.toString());
					
				p2.addChild(p2to1);
				p2.addChild(p2to2);
				//p2.addChild(p2to3);
				p2.addChild(p2to4);
				//...................Menu3..................................
				
				//...................Menu4..................................
				TreeObject p4to1=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE1.toString());
				TreeObject p4to2=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE2.toString());
				TreeObject p4to3=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE3.toString());
				TreeObject p4to4=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE4.toString());
				TreeObject p4to5=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE5.toString());
				
				
				p4.addChild(p4to1);
				p4.addChild(p4to2);
				p4.addChild(p4to3);
				p4.addChild(p4to4);
				p4.addChild(p4to5);
		
				root.addChild(p1);
				root.addChild(p2);
				root.addChild(p4);
				
		return root;
	}
	
	/**
	 * We will set up a dummy model to initialize tree heararchy. In real
	 * code, you will connect to a real model and expose its hierarchy.
	 */
//	private TreeObject createDummyModel() {
//		TreeParent root = new TreeParent("");
//		TreeParent p1=new TreeParent(ApplicationMenuID.FOLDER_NAME1.toString());
//		TreeParent p2=new TreeParent(ApplicationMenuID.FOLDER_NAME2.toString());
//		TreeParent p4=new TreeParent(ApplicationMenuID.FOLDER_NAME4.toString());
//		TreeParent p5=new TreeParent(ApplicationMenuID.FOLDER_NAME5.toString());
//		//...................Menu1..................................
//		TreeObject p1to1=new TreeObject(ApplicationMenuID.FILE_MEDIC1.toString());
//		TreeObject p1to2=new TreeObject(ApplicationMenuID.FILE_MEDIC2.toString());
//		TreeObject p1to3=new TreeObject(ApplicationMenuID.FILE_MEDIC3.toString());
//		TreeObject p1to4=new TreeObject(ApplicationMenuID.FILE_MEDIC4.toString());
//		
//		p1.addChild(p1to1);
//		p1.addChild(p1to2);
//		p1.addChild(p1to3);
//		p1.addChild(p1to4);
//		
//		//...................Menu2..................................
//		TreeObject p2to1=new TreeObject(ApplicationMenuID.FILE_PATIENT1.toString());
//		TreeObject p2to2=new TreeObject(ApplicationMenuID.FILE_PATIENT2.toString());
//		TreeObject p2to3=new TreeObject(ApplicationMenuID.FILE_PATIENT3.toString());
//		TreeObject p2to4=new TreeObject(ApplicationMenuID.FILE_PACIENT4.toString());
//			
//		p2.addChild(p2to1);
//		p2.addChild(p2to2);
//		p2.addChild(p2to3);
//		p2.addChild(p2to4);
//		//...................Menu3..................................
//		
//		//...................Menu4..................................
//		TreeObject p4to1=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE1.toString());
//		TreeObject p4to2=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE2.toString());
//		TreeObject p4to3=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE3.toString());
//		TreeObject p4to4=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE4.toString());
//		TreeObject p4to5=new TreeObject(ApplicationMenuID.FILE_MEDICAMENTE5.toString());
//		
//		
//		p4.addChild(p4to1);
//		p4.addChild(p4to2);
//		p4.addChild(p4to3);
//		p4.addChild(p4to4);
//		p4.addChild(p4to5);
//		
//		//...................Menu5..................................
//		TreeObject p5to1=new TreeObject(ApplicationMenuID.FILE_ADMINISTRARE1.toString());
//		TreeObject p5to2=new TreeObject(ApplicationMenuID.FILE_ADMINISTRARE2.toString());
//		TreeObject p5to3=new TreeObject(ApplicationMenuID.FILE_ADMINISTRARE3.toString());
//		
//		p5.addChild(p5to1);
//		p5.addChild(p5to2);
//		p5.addChild(p5to3);
//		
//		root.addChild(p1);
//		root.addChild(p2);
//		root.addChild(p4);
//		root.addChild(p5);
//		
//		return root;
//	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		
		//MedicPrimar medic=this.medicModel.getMedicPrimar();
		int idType=2;
		//try {
			
		    UserType type=this.medicModel.getUser().getUserType();
			idType=type.getIdUserType();
		
		System.err.println(idType);
		switch (idType) {
		case 1:
			viewer.setInput(createAdminMenu());
			break;
        case 2:
			viewer.setInput(createMedicMenu());
			break;
        case 3:
	        viewer.setInput(createAsistentMenu()); 
	        break;
		default:
			break;
		}
		//viewer.setInput(createDummyModel());
		viewer.addSelectionChangedListener(new NavigationListener());
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * @return the medicModel
	 */
	public MedicModel getMedicModel() {
		return medicModel;
	}

	/**
	 * @param medicModel the medicModel to set
	 */
	public void setMedicModel(MedicModel medicModel) {
		this.medicModel = medicModel;
	}
}
