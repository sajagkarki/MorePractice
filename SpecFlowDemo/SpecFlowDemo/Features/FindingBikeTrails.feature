Feature: Finding biking trail in Utah

As an outdoor enthusiast, I want to see the different biking routes in Utah

@tag1
Scenario: [Searching bike trails]
	Given A search engine "http://www.google.com" is accesible
	When I enter a search criteria "Biking Trails near Park City"
	Then Output should display the options
	And I enter another search criteria "Restaurants in Park City"
	Then Output should display the lunch options
	


