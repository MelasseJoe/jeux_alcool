window.addEventListener( 'load', ev => {

    var height = document.body.clientHeight;
    if (height == 0) {
        height = $('body').height();
    }
    var width = screen.width;
    var ratioEcran = width / 1125;
    var place = (height - 1494 * ratioEcran);
    var tailleLogo = 1072 * ratioEcran * 0.9;
    var hauteurLogo = 290 * ratioEcran * 0.9;
    var marginLogo = (width - tailleLogo)/2;
    var topLogo = (place - hauteurLogo)/2;
    document.getElementById("logo").style.left = marginLogo;
    document.getElementById("logo").style.top = topLogo;
    document.getElementById("logo").style.width = tailleLogo;
    document.getElementById("logo").style.height = hauteurLogo;

    document.getElementById("jeux").style.left = 304 * ratioEcran;
    document.getElementById("jeux").style.bottom = 897 * ratioEcran;
    document.getElementById("chants").style.left = 221 * ratioEcran;
    document.getElementById("chants").style.bottom = 621 * ratioEcran;
    document.getElementById("regles").style.left = 648 * ratioEcran;
    document.getElementById("regles").style.bottom = 927 * ratioEcran;
    document.getElementById("desCartes").style.left = 628 * ratioEcran;
    document.getElementById("desCartes").style.bottom = 569 * ratioEcran;
}, false );
