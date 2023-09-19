(function () {
    "use strict";

    window.onload = function(){
        document.getElementById("submit").addEventListener("click", sub)

        //fetch price from amazon.

        fetch("https://amazon-price1.p.rapidapi.com/search?marketplace=US&keywords=2020%20Apple%20iMac%20with%20Retina%205K%20Display%20(27-inch%2C%208GB%20RAM%2C%20256GB%20SSD%20Storage)", {
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

        fetch("https://bestbuy-products.p.rapidapi.com/product?url=https%3A%2F%2Fwww.bestbuy.com%2Fsite%2Fapple-27-imac-with-retina-5k-display-intel-core-i5-3-1ghz-8gb-memory-256gb-ssd-silver%2F5721940.p%3FskuId%3D5721940&sku=5748618", {
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

