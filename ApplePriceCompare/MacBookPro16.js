(function () {
    "use strict";

    window.onload = function(){
        document.getElementById("submit").addEventListener("click", sub)

        //fetch price from amazon.

        fetch("https://amazon-price1.p.rapidapi.com/search?marketplace=US&keywords=2019%20Apple%20MacBook%20Pro%20(16-inch%2C%2016GB%20RAM%2C%20512GB%20Storage%2C%202.6GHz%20Intel%20Core%20i7)%20-%20Space%20Gray", {
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

        fetch("https://bestbuy-products.p.rapidapi.com/product?url=https%3A%2F%2Fwww.bestbuy.com%2Fsite%2Fapple-macbook-pro-16-display-with-touch-bar-intel-core-i7-16gb-memory-amd-radeon-pro-5300m-512gb-ssd-latest-model-space-gray%2F6366564.p%3FskuId%3D6366564&sku=5748618", {
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

