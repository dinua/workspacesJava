package com.medweb.ui.menu;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import com.medweb.ui.help.ApplicationMenuID;
import com.medweb.ui.help.ChangeViewPage;

public class NavigationListener implements ISelectionChangedListener{

	
	private  String viewId;
	
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
	String e=event.getSelection().toString();
	e=e.substring(1,e.length()-1);
	 int id=ApplicationMenuID.fromString(e).getOrdinalValue();  
	 
	 
	 switch (id) {
	case 8:
		viewId=com.medweb.ui.pacient.PacinetView.ID;
		break;
	case 7:
		viewId=com.medweb.ui.pacient.PacientNewView.ID;
		break;
	case 9:
		viewId=com.medweb.ui.pacient.VisitHistoryView.ID;
		break;
	case 10:
		viewId=com.medweb.ui.pacient.PacinetInactivView.ID;
		break;
	case 20:
		viewId=com.medweb.ui.medic.MedicOrarView.ID;
		break;
	case 21:
		viewId=com.medweb.ui.medic.MedicInfoView.ID;
		break;	
	case 22:
		viewId=com.medweb.ui.medic.MedicCabinetView.ID;
		break;	
	case 23:
		viewId=com.medweb.ui.medic.CasaAsigurariView.ID;
		break;	
	case 40:
		viewId=com.medweb.ui.medicamente.SublistaAView.ID;
		break;
	case 41:
		viewId=com.medweb.ui.medicamente.SublistaBView.ID;
		break;	
		
	case 42:
		viewId=com.medweb.ui.medicamente.SublistaC1View.ID;
		break;	
		
	case 43:
		viewId=com.medweb.ui.medicamente.SublistaC2View.ID;
		break;	
		
	case 44:
		viewId=com.medweb.ui.medicamente.SublistaC3View.ID;
		break;
	case 50:
		viewId=com.medweb.ui.administrare.UtilizatorNouView.ID;
		break;	
	case 51:
		viewId=com.medweb.ui.administrare.UtilizatoriActiviView.ID;
		break;	
	case 52:
		viewId=com.medweb.ui.administrare.UtilizatoriInactiviView.ID;
		break;	
	default:
		 viewId=com.medweb.ui.menu.View.ID;
		break;
	}
	 
	 ChangeViewPage.changeView(viewId,"single");
	}

}
