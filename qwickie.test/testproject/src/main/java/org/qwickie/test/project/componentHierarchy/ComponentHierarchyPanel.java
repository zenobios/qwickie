package org.qwickie.test.project.componentHierarchy;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class ComponentHierarchyPanel extends Panel {

	public ComponentHierarchyPanel(String id, IModel<?> model) {
		super(id, model);
	}

	public ComponentHierarchyPanel(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ComponentHierarchySubPanel("someSubPanelId"));
	}

}
