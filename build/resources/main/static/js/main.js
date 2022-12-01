/* ===================================================================
 * Ethos 1.0.0 - Main JS
 *
 * ------------------------------------------------------------------- */

(function($) {

    "use strict";
    
    const cfg = {
                scrollDuration : 800, // smoothscroll duration
                mailChimpURL   : ''   // mailchimp url
                };
    const $WIN = $(window);


    // Add the User Agent to the <html>
    // will be used for IE10/IE11 detection (Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; rv:11.0))
    const doc = document.documentElement;
    doc.setAttribute('data-useragent', navigator.userAgent);


   /* Choose file Input
    * -------------------------------------------------- */

    let input = document.getElementById("inputTag");
    let imageName = document.getElementById("imageName")

    input.addEventListener("change", ()=>{
        let inputImage = document.querySelector("input[type=file]").files[0];

        imageName.innerText = inputImage.name;
    })

   /* preloader
    * -------------------------------------------------- */
    const ssPreloader = function() {

        $("html").addClass('ss-preload');

        $WIN.on('load', function() {

            // force page scroll position to top at page refresh
            $('html, body').animate({ scrollTop: 0 }, 'normal');

            // will first fade out the loading animation 
            $("#loader").fadeOut("slow", function() {
                // will fade out the whole DIV that covers the website.
                $("#preloader").delay(300).fadeOut("slow");
            }); 
            
            // for hero content animations 
            $("html").removeClass('ss-preload');
            $("html").addClass('ss-loaded');

        });
    };


    /* Dark & Light mode
    * -------------------------------------------------- */
    const modeTheme = document.querySelector("#mode-icon");
    const modeText = document.querySelector(".theme-text");
    modeTheme.onclick = function() {
        document.body.classList.toggle("dark-mode")
        if(document.body.classList.contains("dark-mode")) {
            modeTheme.src = "fonts/half-moon.svg"
            modeText.innerText = "Dark Mode"
        } else {
            modeTheme.src = "fonts/sun-light.svg"
            modeText.innerText = "Light Mode"
        }
    }

   /* pretty print
    * -------------------------------------------------- */
    const ssPrettyPrint = function() {
        $('pre').addClass('prettyprint');
        $( document ).ready(function() {
            prettyPrint();
        });
    };


   /* Menu on Scrolldown
    * ------------------------------------------------------ */
   var ssMenuOnScrolldown = function() {
        
    var menuTrigger = $('.header-menu-toggle');

    $WIN.on('scroll', function() {

        if ($WIN.scrollTop() > 150) {
            menuTrigger.addClass('opaque');
        }
        else {
            menuTrigger.removeClass('opaque');
        }

    });
    };
   /* OffCanvas Menu
    * ------------------------------------------------------ */
   var ssOffCanvas = function() {

    var menuTrigger     = $('.header-menu-toggle'),
        nav             = $('.header-nav'),
        closeButton     = nav.find('.header-nav__close'),
        siteBody        = $('body'),
        mainContents    = $('section, footer');

    // open-close menu by clicking on the menu icon
    menuTrigger.on('click', function(e){
        e.preventDefault();
        siteBody.toggleClass('menu-is-open');
    });

    // close menu by clicking the close button
    closeButton.on('click', function(e){
        e.preventDefault();
        menuTrigger.trigger('click');
    });

    // close menu clicking outside the menu itself
    siteBody.on('click', function(e){
        if( !$(e.target).is('.header-nav, .header-nav__content, .header-menu-toggle, .header-menu-toggle span') ) {
            siteBody.removeClass('menu-is-open');
        }
    });

};


   /* accordion
    * ------------------------------------------------------ */
    const ssAccordion = function() {

        const $allItems = $('.services-list__item');
        const $allPanels = $allItems.children('.services-list__item-body');

        $allPanels.slice(1).hide();

        $allItems.on('click', '.services-list__item-header', function() {

            const $this = $(this),
                  $curItem = $this.parent(),
                  $curPanel =  $this.next();

            if(!$curItem.hasClass('is-active')){
                $allPanels.slideUp();
                $curPanel.slideDown();
                $allItems.removeClass('is-active');
                $curItem.addClass('is-active');
            }
            
            return false;
        });
    };



   /* photoswipe
    * ----------------------------------------------------- */
    const ssPhotoswipe = function() {
        const items = [],
            $pswp = $('.pswp')[0],
            $folioItems = $('.folio-item');

        // get items
        $folioItems.each( function(i) {

            let $folio = $(this),
                $thumbLink =  $folio.find('.folio-item__thumb-link'),
                $title = $folio.find('.folio-item__title'),
                $caption = $folio.find('.folio-item__caption'),
                $titleText = '<h4>' + $.trim($title.html()) + '</h4>',
                $captionText = $.trim($caption.html()),
                $href = $thumbLink.attr('href'),
                $size = $thumbLink.data('size').split('x'),
                $width  = $size[0],
                $height = $size[1];
        
            let item = {
                src  : $href,
                w    : $width,
                h    : $height
            }

            if ($caption.length > 0) {
                item.title = $.trim($titleText + $captionText);
            }

            items.push(item);
        });

        // bind click event
        $folioItems.each(function(i) {

            $(this).find('.folio-item__thumb-link').on('click', function(e) {
                e.preventDefault();
                let options = {
                    index: i,
                    showHideOpacity: true
                }

                // initialize PhotoSwipe
                let lightBox = new PhotoSwipe($pswp, PhotoSwipeUI_Default, items, options);
                lightBox.init();
            });

        });
    };



   /* slick slider
    * ------------------------------------------------------ */
    const ssSlickSlider = function() {
            
        $('.testimonials__slider').slick({
            arrows: false,
            dots: true,
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            pauseOnFocus: false,
            autoplaySpeed: 1500
        });
    };


   /* Animate On Scroll
    * ------------------------------------------------------ */
    const ssAOS = function() {
        
        AOS.init( {
            offset: 100,
            duration: 600,
            easing: 'ease-in-out',
            delay: 300,
            once: true,
            disable: 'mobile'
        });

    };



   /* alert boxes
    * ------------------------------------------------------ */
    const ssAlertBoxes = function() {

        $('.alert-box').on('click', '.alert-box__close', function() {
            $(this).parent().fadeOut(500);
        }); 

    };

    
   /* smooth scrolling
    * ------------------------------------------------------ */
    const ssSmoothScroll = function() {
        
        $('.smoothscroll').on('click', function (e) {
            const target = this.hash;
            const $target = $(target);
            
            e.preventDefault();
            e.stopPropagation();

            $('html, body').stop().animate({
                'scrollTop': $target.offset().top
            }, cfg.scrollDuration, 'swing').promise().done(function () {
                window.location.hash = target;
            });
        });

    };


   /* back to top
    * ------------------------------------------------------ */
    const ssBackToTop = function() {
        
        const pxShow = 800;
        const $goTopButton = $(".ss-go-top")

        // Show or hide the button
        if ($(window).scrollTop() >= pxShow) $goTopButton.addClass('link-is-visible');

        $(window).on('scroll', function() {
            if ($(window).scrollTop() >= pxShow) {
                if(!$goTopButton.hasClass('link-is-visible')) $goTopButton.addClass('link-is-visible')
            } else {
                $goTopButton.removeClass('link-is-visible')
            }
        });
    };
    


   /* initialize
    * ------------------------------------------------------ */
    (function ssInit() {

        ssPreloader();
        ssPrettyPrint();
        ssOffCanvas();
        ssMenuOnScrolldown();
        ssAccordion();
        ssPhotoswipe();
        ssSlickSlider();
        ssAOS();
        ssAlertBoxes();
        ssSmoothScroll();
        ssBackToTop();

    })();

})(jQuery);