describe("Verify WebDriver University link", () => {
   it("Verify correct home page -> CONTACT US", () => {
       browser.setViewportSize({width: 1200, height: 800});
       browser.url('http://www.webdriveruniversity.com/');
       let title = browser.getTitle();
       console.log(title);
       browser.click('#contact-us');
       browser.pause(1000);
   });

   it("check that login button open the login portal page", () => {
       browser.url('http://www.webdriveruniversity.com/');
       browser.click('#login-portal');
       browser.pause(1000)
   });

    it('should have the right title', () => {
        browser.url('https://webdriver.io');
        const title = browser.getTitle();
        console.log(title)
    });
});