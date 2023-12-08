package com.solibri.rule;
import java.util.List;

import com.solibri.smc.api.filter.ComponentFilter;
import com.solibri.smc.api.model.ComponentType;
import com.solibri.smc.api.checking.RuleParameter;

public class RuleProcessor {

    public static void main(String[] args) {
        // Replace this variable with the actual file path
        String filePath = "H:\\Temporary\\SMC_API\\ifcRailing";

        // Call ExcelReader to read Excel data
        ExcelReader excelReader = new ExcelReader();
        List<List<String>> rowData = excelReader.readExcel(filePath);

        // Process each row and create HennRule instances
        for (List<String> row : rowData) {
            HennRule hennRule = createHennRule(row);
            
            // Now you can do further processing or actions with hennRule as needed
            // ...
        }
    }

    private static HennRule createHennRule(List<String> row) {
        // Extract data from the row and create a new HennRule instance
        // Adjust this based on the structure of your Excel data
    	String typeName = row.get(0); // Assuming the class name is in the first column
        ComponentFilter rpComponentFilterValue = ComponentFilter.componentTypeIs(ComponentType.BEAM);
        String rpComponentFilter2Value = row.get(1);

        // Assuming HennRule has a constructor that takes parameters
        HennRule hennRule = new HennRule();
        hennRule.setRpComponentFilter3(rpComponentFilterValue);
       
        // Set other parameters as needed

        // Assuming HennRule has a constructor that takes parameters
        return hennRule; /* other parameters */
    }
}
