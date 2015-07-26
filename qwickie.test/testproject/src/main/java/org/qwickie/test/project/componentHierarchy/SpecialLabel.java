package org.qwickie.test.project.componentHierarchy;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public class SpecialLabel extends Label {

	public SpecialLabel(String id, IModel<?> model) {
		super(id, model);
	}

	public SpecialLabel(String id, String label) {
		super(id, label);
	}

	public SpecialLabel(String id) {
		super(id);
	}

}
