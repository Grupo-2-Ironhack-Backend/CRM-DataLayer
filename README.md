# CRM - OOP Homework (Unit 2)

Delivered exercise. CRM - DataLayer Homework (Unit 3) (IRONHACK)

Welcome to the ultimate CRM (Customer Relationship Management) system. CRMs are a tool that almost every sales team uses to track prospective and existing customers through the sales process.

This CRM allows us to:

- Track Leads
- Convert Leads into Opportunities
- Associate Sales Representarives with Leads or Opportunities
- Associate an Opportunity with an Account.
- Associate a Contact with an Opportunity.
- Generate a wide variety of reports. (In fact . . . maybe not that wide of a variety)

Leads, Sales Representatives, Contacts, Opportunities and Accounts are stored in a MySQLremote database so you never loose information from your beloved customers.

## Diagrams

Case Diagram

![Case Diagram](case-diagram.jpg "Case diagram")

Class Diagram

![Class Diagram](class-diagram.jpg "Class diagram")

## How to try it

You just need to run the program and choose the option you need.
You can interact with commands like:

<table border="0">
 <tr style="border: none!important;">
    <td style="border: none!important;">
showleads: <br>
showopportunities: <br>
showcontacts: <br>
showaccounts: <br>
showsalesreps: <br>
lookuplead: <br>
newlead: <br>
newsalesrep: <br>
removelead: <br>
convert: <br>
close-lost: <br>
close-won: <br>
exit: <br>
</td>
    <td style="border: none!important;">
list of leads<br>
list of opportunities<br>
list of contacts<br>
list of accounts<br>
list of opportunities<br>
specific lead by id<br>
create a new lead<br>
create a new sales representative<br>
removes a lead<br>
converts leads to opportunities<br>
opportunity status lost <br>
opportunity status won <br>
exits the program<br>
</td>
 </tr>
</table>

## Requirements

We are providing our own database. Just clone the code, open it with IntelliJ and you are good to go.

Remember that in order to try the tests you need to comment the 'run()' method in the class CrmDataLayerApplication.java 

## Usage

You just need to type the command you need, press ENTER and follow the given instructions.

Here is an example:

![example](example.gif "Example CLI")

## Contributing

Pull requests are welcome

## License

[MIT](LICENSE.txt)
