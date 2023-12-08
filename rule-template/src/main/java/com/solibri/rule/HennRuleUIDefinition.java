package com.solibri.rule;


import com.solibri.smc.api.checking.RuleResources;
import com.solibri.smc.api.ui.BorderType;
import com.solibri.smc.api.ui.UIComponent;
import com.solibri.smc.api.ui.UIContainer;
import com.solibri.smc.api.ui.UIContainerVertical;
import com.solibri.smc.api.ui.UILabel;
import com.solibri.smc.api.ui.UIRuleParameter;

/**
 * Class that provides the UI layout for Clash Detection Rule. The UI Consists
 * of two component filters and one double values parameter field for length.
 */
class HennRuleUIDefinition {

	/**
	 * The Clash Detection Rule.
	 */
	private final HennRule hennRule;

	/**
	 * The UI definition container.
	 */
	private final UIContainer uiDefinition;

	/**
	 * Basic constructor.
	 *
	 * @param clashDetectionRule the clash detection rule
	 */
	public HennRuleUIDefinition(HennRule hennRule) {
		this.hennRule = hennRule;
		this.uiDefinition = createUIDefinition();
	}

	/**
	 * Returns the UI definition of the rule.
	 *
	 * @return the UI definition container of the rule
	 */
	public UIContainer getDefinitionContainer() {
		return uiDefinition;
	}

	/**
	 * Create the UI definition of the rule.
	 *
	 * @return the UI definition container of the rule
	 */
	private UIContainer createUIDefinition() {
		/*
		 * Fetch the resources for this rule.
		 */
		RuleResources resources = RuleResources.of(hennRule);

		/*
		 * Create the vertical component container.
		 */
		UIContainer uiContainer = UIContainerVertical.create(resources.getString("UI.HennRule.TITLE"),
			BorderType.LINE);

		/*
		 * Add the description of the rule.
		 */
		uiContainer.addComponent(UILabel.create(resources.getString("UI.HennRule.DESCRIPTION")));

		/*
		 * Add the first filter for components to check.
		 */
		uiContainer.addComponent(createFirstComponentFilterUIDefinition());

		/*
		 * Add the second filter for components to check.
		 */
		uiContainer.addComponent(createSecondComponentFilterUIDefinition());

		/*
		 * Add the tolerance filter for clash of components.
		 
		uiContainer.addComponent(createAllowedToleranceUIDefinition());
		*/
		return uiContainer;
	}

	/**
	 * Create the UI definition of the first component filter.
	 *!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * @return the UI definition container of the first component filter
	 */
	
	private UIComponent createFirstComponentFilterUIDefinition() {
		UIContainer uiContainer = UIContainerVertical.create();
		uiContainer.addComponent(UIRuleParameter.create(hennRule.rpComponentFilter3));
		/**uiContainer.addComponent(UI);*/
		return uiContainer;
	}

	/**
	 * Create the UI definition of the second component filter.
	 *
	 * @return the UI definition container of the second component filter
	 */
	private UIComponent createSecondComponentFilterUIDefinition() {
		UIContainer uiContainer = UIContainerVertical.create();
		uiContainer.addComponent(UIRuleParameter.create(hennRule.rpComponentFilter2));
		return uiContainer;
	}

	/**
	 * Create the UI definition of the allowed tolerance.
	 *
	 * @return the UI definition container of the allowed tolerance
	 
	private UIComponent createAllowedToleranceUIDefinition() {
		UIContainer uiContainer = UIContainerVertical.create();
		uiContainer.addComponent(UIRuleParameter.create(hennRule.rpAllowedTolerance));
		return uiContainer;
	}
	*/
}
