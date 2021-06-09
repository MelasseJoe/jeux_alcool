window.addEventListener( 'load', ev => {
    var width = screen.width;
    var tailleImage = 100;
    var tailleTitre = $('#titre').width();//document.getElementById("titre").offsetWidth;
    var taillePolice = 32;
    while(tailleTitre > 0.6*width){
        document.getElementById("titre").style.fontSize = --taillePolice;
        //document.getElementById("titre").style.fontSize = (parseInt(window.getComputedStyle(document.getElementById('titre'), null).getPropertyValue('font-size')) - 1) +"px";
        tailleTitre = $('#titre').width();//document.getElementById("titre").offsetWidth;
    }
    var heightTitre = Math.min($('h1').height(),$('h1').innerHeight(),$('h1').outerHeight(),parseInt($('h1').css("height")),42);//document.getElementById("titre").offsetHeight;
    document.getElementsByClassName("image1")[0].style.bottom = (heightTitre - 26)/2;
}, false );