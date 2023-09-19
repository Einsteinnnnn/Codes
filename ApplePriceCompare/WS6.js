(function () {
    "use strict";

    window.onload = function(){
        document.getElementById("submit").addEventListener("click", sub)

        //fetch price from amazon.

        fetch("https://amazon-price1.p.rapidapi.com/search?marketplace=US&keywords=New%20Apple%20Watch%20Series%206%20(GPS%2C%2040mm)%20-%20Blue%20Aluminum%20Case%20with%20Deep%20Navy%20Sport%20Band", {
            "method": "GET",
            "headers": {
                "x-rapidapi-key": "ede3e37a32msh7ee72e454d92ddcp170afcjsn8d76ea6ebec4",
                "x-rapidapi-host": "amazon-price1.p.rapidapi.com"
            }
        })
            .then(response => response.json())
            .then(displayData)
            .catch(err => {
                console.error(err);
            });

        function displayData(response){
            document.getElementById('item-desc1').textContent = response[0].title;
            document.getElementById('amazon1').textContent = response[0].price;
        }

        // fetch price from Best Buy

        fetch("https://bestbuy-products.p.rapidapi.com/product?url=https%3A%2F%2Fwww.bestbuy.com%2Fsite%2Fapple-watch-series-6-gps-40mm-productred-aluminum-case-with-productred-sport-band-productred%2F6215923.p%3FskuId%3D6215923", {
            "method": "GET",
            "headers": {
                "x-rapidapi-key": "9eabc92e42mshcbe2969f600a38bp1162f5jsn52a0ef3d2cdf",
                "x-rapidapi-host": "bestbuy-products.p.rapidapi.com"
            }
        })
            .then(response => response.json())
            .then(displayData1)
            .catch(err => {
                console.error(err);
            });

        function displayData1(response){
            document.getElementById('bestbuy').textContent = response.prices.currency+response.prices.current_price;
        }

    }

    //Subscribe button action
    function sub(){
        alert("Thank you for subscription!")
    }

})();