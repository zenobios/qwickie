package org.qwickie.test.project.componentHierarchy;

import org.apache.wicket.markup.html.WebPage;

public class ComponentHierarchyTestPage extends WebPage {

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ComponentHierarchyPanel("somePanelId"));
	}
}
