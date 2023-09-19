# CSC-336-Final-Project

1. The title/theme of your web app.

Apple products’ price comparing between different shopping platforms. 
 
2. Your team members

Haozhe Wu, Ash Xu
 
3. What is your goal? What does your web app do?  What are some of the special features?  Who would like to use this web app?

Our main goal is that by browsing our website, users can clearly know from which website they can buy the same Apple products at the lowest price. 
Our website will show the viewers the price comparison of Apple products on various shopping sites so that viewers can directly see the different discounts provided by different sites. 
Users will save a lot of time by visiting our website because they don’t need to browse every shopping website to search for the best deal for one product. 
Our target audiences are those who are considering buying a new Apple product at a decent price, whether it’s released recently or a few years ago. 

4.  What software tools do you use? 

HTML, CSS, API, JSON
 
5. What are some of the challenges? 

Finding the same item on different sites can be challenging because the same item may have different names or titles on different sites.
Second, it was difficult to find some API that suited our theme. We need to find some API that is reliable, real, and has clear data classification. 
Third, given our unfamiliarity with API, we may need to spend more time on putting the data from different websites together. 

6. What APIs did we use？

We used a total of two APIs, one is _Amazon Price_, and another is _BestBuy Products_. Both of these two APIs are from _RapidAPI_, and they're not completely free.
Because each configuration for each product has its own unique link, the API is called every time a price for a product is displayed.
Because we have to pay to use both APIs, we decided to show only one available configuration for each product for the time being.

Here are the links for the APIs:  
_Amazon Price_: https://rapidapi.com/ajmorenodelarosa/api/amazon-price1  
_BestBuy Products_: https://rapidapi.com/ZombieBest/api/bestbuy-products/pricing  

7. UI design

We want to give users a simple, clear, easy to understand web pages, this is our guidelines for making web pages.
When you open our website, you will see the title of our website _"Apple Price Compare"_ at the top of the page.
The title will give you a quick overview of the main purpose of our website.
You will also find a navigation bar at the top of the page, where you can select the product you want to search for.
By going to the specific page for each product, you can see pictures, descriptions, and specific available configurations for each product.
All configuration names, prices are taken from the API. so they are real-time and automatically updated.
But as we mentioned before, since there is a fee for using these APIs every-time we fetch, we are only offering one available configuration for each product for now.
But don't worry, if we wish to actually run our website in the future, expanding the available configurations is very easy and convenient.