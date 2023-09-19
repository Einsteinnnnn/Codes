(function () {
    "use strict";

    window.onload = function(){
        document.getElementById("submit").addEventListener("click", sub)
        
    //fetch price from amazon.

    fetch("https://amazon-price1.p.rapidapi.com/search?marketplace=US&keywords=M1%20MacBook%20Air", {
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
    fetch("https://bestbuy-products.p.rapidapi.com/product?url=https%253A%252F%252Fwww.bestbuy.com%252Fsite%252Fmacbook-air-13-3-laptop-apple-m1-chip-8gb-memory-256gb-ssd-latest-model-space-gray%252F5721600.p%253FskuId%253D5721600&sku=5721600", {
	"method": "GET",
	"headers": {
		"x-rapidapi-key": "ede3e37a32msh7ee72e454d92ddcp170afcjsn8d76ea6ebec4",
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

