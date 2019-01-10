const webdriverio = require('webdriverio');
const options = {desiredCapabilities: {browserName: 'chrome'}};
const client = webdriverio.remote(options);

client
    .init()
    .setViewportSize({
        width: 1200,
        height: 800
    })
    .url('http://webdriveruniversity.com/')
    .getTitle().then(function (title) {
    console.log('Title is: ' + title)
})
    .click('#contact-us')
    .pause(3000)
    .end();