(function () {
    "use strict";

    window.onload = function(){
        gallery();
        userSignIn();
        document.getElementById("submit").addEventListener("click", sub);

    }

    //Change the main image automatically
    function gallery(){
        let gallery = document.getElementById("imageGallery");
    //    Get the branch


        let start = true;
        let add = setInterval(function (){
            if(start) {
                let old = document.getElementById("mainPicture");
                old.parentNode.removeChild(old);

                //Randomly change the image
                let random = parseInt(Math.random() * 10);
                let img = document.createElement("img");
                img.id = "mainPicture"
                img.src = "img/" + random + ".jpeg";
                gallery.append(img);
            }else{
                clearInterval(add)
            }
        },4000)
    }


    //Subscribe button action
    function sub(){
        alert("Thank you for subscription!")
    }


    //Create a personalized experience
    function userSignIn() {
        let name = prompt("Hi! What's your name?");
        let random = parseInt(Math.random() * 100);
        let user = document.getElementById("user");

        if (name != null) {
            if (random % 4 < 1) {
                user.innerText = ("Hi " + name + "! Your lucky number is " + random + ". Do you want to buy a new Mac?");
            } else if (random % 4 >= 1 && random % 4 < 2) {
                user.innerText = ("Hi " + name + "! Your lucky number is " + random + ". Do you want to buy a new iPad?");
            } else if (random % 4 >= 2 && random % 4 < 3) {
                user.innerText = ("Hi " + name + "! Your lucky number is " + random + ". Do you want to buy a new iPhone?");
            } else if (random % 4 >= 3 && random % 4 < 4) {
                user.innerText = ("Hi " + name + "! Your lucky number is " + random + ". Do you want to buy a new Apple Watch?");
            }
        }
    }

})();

