Feature:Feature1

A short summary of the feature

@tag1
	Scenario Outline: [Finding bike trails near Salt Lake City,Utah]
		Given A data search engine are <url> accesible
		When I data entered with criteria <text> xyz
		Then Output should display the optionss

	Examples: 
	| url                      | text                              |
	| https://www.google.com/  | Biking trails near Salt Lake City |
	| https://www.google2.com/ | Hiking trails near Park City      |
	| https://www.dummy.com/   | Dummy                             |
