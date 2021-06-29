Feature: Vinyl search
  To allow customers to find vinyls, the vinyl library must offer seek methods.

  Scenario: Search vinyls by release year
    Given an album with the title 'The Dark Side of the Moon', created by the band 'Pink Floyd', released in '01-03-1973' on the label 'Harvest Records'
    	And an album with the title 'Bad', created by the artist 'Michael Jackson', released in '31-08-1987' on the label 'Epic Records'
    	And an album with the title 'Tubular Bells', created by the artist 'Mike Oldfield', released in '25-05-1973' on the label 'Virgin Records'
    	And an album with the title 'Like a Virgin', created by the artist 'Madonna', released in '12-11-1984' on the label 'Sire Records'
    	And an album with the title 'Yellow Submarine', created by the band 'The Beatles', released in '17-01-1969' on the label 'Apple'
    	And an album with the title 'Brothers in Arms', created by the band 'Dire Straits', released in '01-05-1985' on the label 'Vertigo Records'
    When the customer searches for vinyls released between '1970' and '1980'
    Then 2 albums should have been found
      And album 1 should have the title 'Tubular Bells'
      And album 2 should have the title 'The Dark Side of the Moon'
      