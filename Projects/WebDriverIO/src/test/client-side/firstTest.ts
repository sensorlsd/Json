let expect = require('chai').expect;

describe('webdriver.io api page', () => {
    it('should be able to filter for commands',  () =>  {
        browser.url('/api.html');
        browser.debug();
        

        // filtering property commands
        $('.searchbar input').setValue('getT');

        // get all results that are displayed
        let results = $$('.commands.property a').filter((link) =>{
            return link.isVisible();
        });

        // assert number of results
        expect(results.length).to.be.equal(3);

        // check out second result
        results[1].click();
        expect($('.doc h1').getText()).to.be.equal('GETTEXT');
    });
});