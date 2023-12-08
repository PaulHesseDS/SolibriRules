package com.solibri.rule;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.solibri.smc.api.checking.FilterParameter;
import com.solibri.smc.api.checking.OneByOneRule;
import com.solibri.smc.api.checking.Result;
import com.solibri.smc.api.checking.ResultFactory;
import com.solibri.smc.api.checking.RuleParameters;
import com.solibri.smc.api.checking.RuleParameter;
import com.solibri.smc.api.checking.StringParameter;
import com.solibri.smc.api.model.Component;
import com.solibri.smc.api.model.ComponentType;
import com.solibri.smc.api.ui.UIContainer;
import com.solibri.smc.api.filter.ComponentFilter;





public final class HennRule extends OneByOneRule {
	
	private  RuleParameters params = RuleParameters.of(this);
	private final StringParameter stringParameter = params.createString("MyStringParameter");
	//private final FilterParameter rpComponentFilter = this.getDefaultFilterParameter();
	public FilterParameter rpComponentFilter = this.getDefaultFilterParameter();
	private final String COMPONENT_FILTER_PARAMETER_ID2 = "rpComponentFilter2";
	
	private ComponentFilter newComp = ComponentFilter.componentTypeIs(null);
	final FilterParameter rpComponentFilter2 = params.createFilter(COMPONENT_FILTER_PARAMETER_ID2);
	public FilterParameter rpComponentFilter3 = params.createFilter("Type");
	ComponentFilter test = rpComponentFilter.getValue();
	rpComponentFilter3.setValue(test);

	
/*
rpComponentFilter3setValue(ComponentType.BEAM);
	// Setter methods for dynamically setting parameters
    public void setRpComponentFilter3(ComponentFilter filter) {
		rpComponentFilter3.setValue(filter);
    }

*/
	
	
	private final HennRuleUIDefinition uiDefinition = new HennRuleUIDefinition(this);
	
	@Override
	public Collection<Result> check(Component component, ResultFactory resultFactory) {
		String stringParameterValue = stringParameter.getValue();
		Result result = resultFactory
			.create(stringParameterValue, "Description");
		return Collections.singleton(result);
	}
	
	@Override
	public UIContainer getParametersUIDefinition() {
		return uiDefinition.getDefinitionContainer();
	}


}
/*
String filePath = "path/to/your/excel/file.xlsx";


 @Override
    public UIContainer getParametersUIDefinition() {
        // Call ExcelReader to read Excel data and populate parameters
        ExcelReader excelReader = new ExcelReader();
        List<List<String>> columnData = excelReader.readExcel(filePath);
        
        // Print the column data (for testing/debugging purposes)
        for (int columnIndex = 0; columnIndex < columnData.size(); columnIndex++) {
            System.out.print("Column " + columnIndex + ": ");
            for (String cellValue : columnData.get(columnIndex)) {
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        
        return uiDefinition.getDefinitionContainer();
    }
 */