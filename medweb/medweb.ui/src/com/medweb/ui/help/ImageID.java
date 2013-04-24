package com.medweb.ui.help;

public enum ImageID {

	IMAGE_NEW("D:/medweb/medweb.ui/icons/new_con.gif"),
	IMAGE_DELETE("D:/medweb/medweb.ui/icons/delete_obj.gif"),
	IMAGE_SAVE("D:/medweb/medweb.ui/icons/save_edit.gif"),
	IMAGE_EDITOR("D:/medweb/medweb.ui/icons/editor.gif"),
	IMAGE_ADD_EXC("D:/medweb/medweb.ui/icons/add_exc.gif"),
	IMAGE_ADD_OBJ("D:/medweb/medweb.ui/icons/add_obj.gif"),
	IMAGE_EDITOR_GRAY("D:/medweb/medweb.ui/icons/editor_gray.png"),
	IMAGE_PASTE_EDIT("D:/medweb/medweb.ui/icons/paste_edit.gif"),
	IMAGE_ROSOURCE_HISTORY("D:/medweb/medweb.ui/icons/resource_hist.gif"),
	IMAGE_RESET("D:/medweb/medweb.ui/icons/refresh_tab.gif"),
	IMAGE_IMPORT("D:/medweb/medweb.ui/icons/import_wiz.gif"),
	
	IMAGE_BACKGROUND_ORAR("D:/medweb/medweb.ui/icons/footer_shadow.png"),
	
	;
	
	private String path;
	
	private ImageID(String string){
		this.path=string;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.path;
	}
	
	
}
