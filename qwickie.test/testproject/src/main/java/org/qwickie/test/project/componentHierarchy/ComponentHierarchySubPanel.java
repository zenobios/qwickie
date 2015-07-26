package org.qwickie.test.project.componentHierarchy;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class ComponentHierarchySubPanel extends Panel {

	public ComponentHierarchySubPanel(String id, IModel<?> model) {
		super(id, model);
	}

	public ComponentHierarchySubPanel(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new SpecialLabel("someLabelId"));
	}

}
