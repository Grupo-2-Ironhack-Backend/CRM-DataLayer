package CRMDataLayer.ui;

public class TextMenus {

    public static String intro = "\nType your command or type 'crm --help' to show the possible options";

    public static String reportingBySalesRep = "\n\n\tReporting By SalesRep\n\n" +
            "\t\"Report Lead by SalesRep\": A count of Leads by SalesRep\n" +
            "\t\"Report Opportunity by SalesRep\": A count of all Opportunities by SalesRep\n" +
            "\t\"Report CLOSED-WON by SalesRep\": A count of all CLOSED_WON Opportunities\n" +
            "\t\"Report CLOSED-LOST by SalesRep\": A count of all CLOSED_LOST Opportunities by SalesRep\n" +
            "\t\"Report OPEN by SalesRep\": A count of all OPEN Opportunities by SalesRep\n";

    public static String reportingByProduct = "\n\tReporting By Product\n\n" +
                    "\t\"Report Opportunity by the product\": A count of all Opportunities by the product\n" +
                    "\t\"Report CLOSED-WON by the product\": A count of all CLOSED_WON Opportunities by the product\n" +
                    "\t\"Report CLOSED-LOST by the product\": A count of all CLOSED_LOST Opportunities by the product\n" +
                    "\t\"Report OPEN by the product\": A count of all OPEN Opportunities by the product\n";

    public static String reportingByCountry = "\n\tReporting By Country\n\n" +
            "\t\"Report Opportunity by Country\": A count of all Opportunities by country\n" +
            "\t\"Report CLOSED-WON by Country\": A count of all CLOSED_WON Opportunities by country\n" +
            "\t\"Report CLOSED-LOST by Country\": A count of all CLOSED_LOST Opportunities by country\n" +
            "\t\"Report OPEN by Country\": A count of all OPEN Opportunities by country\n";

    public static String reportingByCity = "\n\tReporting By City\n\n" +
            "\t\"Report Opportunity by City\": A count of all Opportunities by City\n" +
            "\t\"Report CLOSED-WON by City\": A count of all CLOSED_WON Opportunities by City\n" +
            "\t\"Report CLOSED-LOST by City\": A count of all CLOSED_LOST Opportunities by City\n" +
            "\t\"Report OPEN by City\": A count of all OPEN Opportunities by City\n";

    public static String reportingByIndustry = "\n\tReporting By Industry\n\n" +
            "\t\"Report Opportunity by Industry\": A count of all Opportunities by Industry\n" +
            "\t\"Report CLOSED-WON by Industry\": A count of all CLOSED_WON Opportunities by Industry\n" +
            "\t\"Report CLOSED-LOST by Industry\": A count of all CLOSED_LOST Opportunities by Industry\n" +
            "\t\"Report OPEN by Industry\": A count of all OPEN Opportunities by Industry\n";

    public static String employeeCountState = "\n\tReporting EmployeeCount States\n\n" +
            "\t\"Mean EmployeeCount\": The mean employeeCount\n" +
            "\t\"Median EmployeeCount\": The median employeeCount\n" +
            "\t\"Max EmployeeCount\": The maximum employeeCount\n" +
            "\t\"Min EmployeeCount\": The minimum employeeCount\n";

    public static String quantityState = "\n\tReporting Quantity States\n\n" +
            "\t\"Mean Quantity\": The mean Quantity of products\n" +
            "\t\"Median Quantity\": The median Quantity of products\n" +
            "\t\"Max Quantity\": The maximum Quantity of products\n" +
            "\t\"Min Quantity\": The minimum Quantity of products\n";

    public static String opportunityState = "\n\tReporting Opportunity States\n\n" +
            "\t\"Mean Opps per Account\": The mean number of Opportunities associated with an Account\n" +
            "\t\"Median Opps per Account\": The median number of Opportunities associated with an Account \n" +
            "\t\"Max Opps per Account\": The maximum number of Opportunities associated with an Account\n" +
            "\t\"Min Opps per Account\": The minimum number of Opportunities associated with an Account\n\n";

    public static String mainMenu = "\n\n================= Welcome to IronCRM =================\n" +
            "\nUse this tool to interact with your Lead database\n" +
            "and perform operations from them:\n\n" +
            "\t\"crm showleads\": shows a list of all leads presents in database.\n" +
            "\t\"crm showopportunities\": shows a list of all Opportunities presents in database.\n" +
            "\t\"crm showcontacts\": shows a list of all contacts presents in database.\n" +
            "\t\"crm showaccounts\": shows a list of all accounts presents in database.\n" +
            "\t\"crm lookuplead\": returns an specific lead, searched by id.\n" +
            "\t\"crm newlead\": creates a new lead by asking for the new info.\n" +
            "\t\"crm removelead\": removes the lead associated with specified id.\n" +
            "\t\"crm convert\": converts a lead into an opportunity and creates \n" +
            "\t\t\tits associated contact and account.\n" +
            "\t\"crm close-lost\": changes opportunity status to \"CLOSED-LOST\" to\n" +
            "\t\t\treflect that this opportunity will not become a sale.\n" +
            "\t\"crm close-won\": changes opportunity status to \"CLOSED-WON\" to\n" +
            "\t\t\treflect that this opportunity will become a sale." +
            "\t\"crm New SalesRep\": \n" +
            "\t\"crm salesreprep\": show options for SalesRep reporting\n" +
            "\t\"crm productrep\": show options for Product reporting\n" +
            "\t\"crm countryrep\": show options for Country reporting\n" +
            "\t\"crm cityrep\": show options for City reporting\n" +
            "\t\"crm industryrep\": show options for Industry reporting\n" +
            "\t\"crm employeerep\": show options for employeeCount reporting\n" +
            "\t\"crm quantityrep\": show options for Quantity reporting\n" +
            "\t\"crm opportunityrep\": show options for Opportunity reporting\n" +
            "\t\"crm exit\": exits the program.\n";

    public static String commandResume = "\n\n================= Cheatsheet: =================\n\n" +
            "\t\"crm showleads\": list of leads\n" +
            "\t\"crm showopportunities\": list of Opportunities\n" +
            "\t\"crm showcontacts\": list of contacts\n" +
            "\t\"crm showaccounts\": list of accounts\n" +
            "\t\"crm lookuplead\": specific lead by id\n" +
            "\t\"crm newlead\": create a new lead\n" +
            "\t\"crm removelead\": removes a lead\n" +
            "\t\"crm convert\": converts a lead to an opportunity\n" +
            "\t\"crm close-lost\": opportunity status changed to lost sale\n" +
            "\t\"crm close-won\": opportunity status changed to won sale\n" +
            "\t\"crm newsalesrep\": create a new salesrep\n" +
            "\t\"crm salesreprep\": show options for SalesRep reporting\n" +
            "\t\"crm productrep\": show options for Product reporting\n" +
            "\t\"crm countryrep\": show options for Country reporting\n" +
            "\t\"crm cityrep\": show options for City reporting\n" +
            "\t\"crm industryrep\": show options for Industry reporting\n" +
            "\t\"crm employeerep\": show options for employeeCount reporting\n" +
            "\t\"crm quantityrep\": show options for Quantity reporting\n" +
            "\t\"crm opportunityrep\": show options for Opportunity reporting\n" +
            "\t\"exit\": exits the program\n";
}
