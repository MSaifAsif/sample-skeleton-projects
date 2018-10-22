describe('Site smoke', function () {
    it('Visits the search page and search for Mallorca', function () {
        cy.visit('www.holidu.de')

        cy.get('#searchBarForm').within(() => {
            cy.get('input').type('Mallorca, Spanien')
        })
        cy.get('.AutocompleteWrapper').click()
        cy.get('#main').click({force: true})

        cy.get('.CTASearchButton').click({force: true})
    })

    it('Make sure Mallorca hits are more than zero', function () {
        cy.request('https://www.holidu.de/rest/search?searchRequestRegionCountry=spanien&searchRequestRegionName=mallorca')
            .should((response) => {
                expect(response.status).to.eq(200)
                expect(response.body).to.have.property('countOfResults')
                expect(response.body).to.have.property('countOfPages')
                expect(response.body.countOfResults).to.not.eq('0')
            })
    })

})


