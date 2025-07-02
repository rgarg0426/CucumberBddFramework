
Feature: Yatra application search functionality

Background: User Launch the browser
Given User opens the Yatra application

Scenario: User enters source
When User enters "Ag" in the departure field
Then List of searched source items display and user selects "Kheria" from the list
Then Agra should be displayed in the Departure box.

Scenario: User enters destination
When User enters "pu" in the destination field
Then List of searched destination items display and user selects "Pula" from the list
Then Pula should be displayed in the Departure box.