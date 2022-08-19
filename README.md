# CRM - OOP Homework (Unit 2)

Delivered exercise. CRM - OOP Homework (Unit 2) (IRONHACK)

Welcome to the ultimate CRM (Customer Relationship Management) system. CRMs are a tool that almost every sales team uses to track prospective and existing customers through the sales process.

This CRM allows us to:

- Track Leads
- Convert Leads into Opportunities
- Associate an Opportunity with an Account.
- Associate Contacts with an Opportunity.

Leads, Contacts, Opportunities and Accounts are stored in a GitHub repository so you never loose information from your beloved customers. You also get your local copy of your updates.

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
lookuplead: <br>
newlead: <br>
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
specific lead by id<br>
create a new lead<br>
removes a lead<br>
converts a lead to an opportunity<br>
opportunity status changed to lost sale<br>
opportunity status changed to won sale<br>
exits the program<br>
</td>
 </tr>
</table>

## Requirements

First of all you need to clone the code and include the Access Token that we have sent you so your updates become persistent in a remote repository. The Access Token needs to be pasted in the field 'JAVA_APP_PASSWORD' in the resources/config.properties file.

After that you have two options to run the code:
- Option 1: You need to have IntelliJ in your local system to clone this repository and run it.
- Option 2: Alternatively, you can build a Docker image by using the Dockerfile included in the repository and run your own image.

## Usage

You just need to type the command you need, press ENTER and follow the given instructions.

Here there is an example:

![example](example.gif "Example CLI")

## Contributing

Pull requests are welcome

## License

[MIT](LICENSE.txt)
