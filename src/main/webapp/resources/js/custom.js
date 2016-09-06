/* ----------------------------- 
Pre Loader
----------------------------- */
$(window).load(function() {
	'use strict';
	$('.loading-icon').delay(500).fadeOut();
	$('#preloader').delay(800).fadeOut('slow');
});


/* -----------------------------
Backgroung slider
----------------------------- */
$(window).ready(function() {
	'use strict';
	$.vegas('slideshow', {
	  backgrounds:[
		{ src:'/resources/images/bg-slider/10623516_653551454747793_2963377976519132811_o.jpg', fade:1000 },
		{ src:'/resources/images/bg-slider/12118880_634258176677121_6103810778428121664_n.jpg', fade:1000 },
		{ src:'/resources/images/bg-slider/12314662_650750091694596_2392224046859293333_o.jpg', fade:1000 },
		{ src:'/resources/images/bg-slider/1500886.jpg', fade:1000 },
		{ src:'/resources/images/bg-slider/10295537.jpg', fade:1000 },
		{ src:'/resources/images/bg-slider/12310663_651146334988305_5722236951511783585_n.jpg', fade:1000 }
	  ]
	})();
});




/* -----------------------------
Scroll into viewPort Animation
----------------------------- */
$(document).ready(function() {
	'use strict';
	$('.animated').appear(function() {
		var element = $(this),
			animation = element.data('animation'),
			animationDelay = element.data('animation-delay');
			if ( animationDelay ) {

				setTimeout(function(){
					element.addClass( animation + " visible");
				}, animationDelay);

			} else {
				element.addClass( animation + " visible");
			}
	});
});


/* -----------------------------
NiceScroll
----------------------------- */
$(document).ready(function() {
	'use strict';
    $("html").niceScroll({
		cursorcolor: '#E74C3C',
		cursoropacitymin: '1',
		cursorborder: '0px',
		cursorborderradius: '0px',
		cursorwidth: '5px',
		cursorminheight: 60,
		horizrailenabled: false,
		zindex: 1090
	});
  });





/* -----------------------------
Card Style Script
----------------------------- */
$(document).ready(function() {
	'use strict';
	var $el 			= $( '#card-ul' ),
		sectionFeature  = $('#section-feature'),
		baraja 			= $el.baraja();

		if ( $(window).width() > 480) {
			sectionFeature.appear(function(){
				baraja.fan({
					speed : 1300,
					easing : 'ease-out',
					range : 100,
					direction : 'right',
					origin : { x : 50, y : 200 },
					center : true
				});
			});
			$('#feature-expand').click(function() {
				baraja.fan({
					speed : 500,
					easing : 'ease-out',
					range : 100,
					direction : 'right',
					origin : { x : 50, y : 200 },
					center : true
				});
			});
		} else {
			sectionFeature.appear(function(){
				baraja.fan({
					speed : 1300,
					easing : 'ease-out',
					range : 80,
					direction : 'left',
					origin : { x : 200, y : 50 },
					center : true
				});
			});
			$('#feature-expand').click(function() {
				baraja.fan({
					speed : 500,
					easing : 'ease-out',
					range : 80,
					direction : 'left',
					origin : { x : 200, y : 50 },
					center : true
				});
			});
		}

	// Feature navigation
	$('#feature-prev').on( 'click', function( event ) {
		baraja.previous();
	});

	$('#feature-next').on( 'click', function( event ) {
		baraja.next();
	});

	// close Features
	$('#feature-close').on( 'click', function( event ) {
		baraja.close();
	});
});

/* -----------------------------
Fitvids init
----------------------------- */
 $(document).ready(function(){
    'use strict';
    $('.video-content').fitVids();
 });


/* -----------------------------
IE 9 Placeholder fix
----------------------------- */
$('[placeholder]').focus(function() {
  var input = $(this);
  if (input.val() == input.attr('placeholder')) {
    input.val('');
    input.removeClass('placeholder');
  }
}).blur(function() {
  var input = $(this);
  if (input.val() == '' || input.val() == input.attr('placeholder')) {
    input.addClass('placeholder');
    input.val(input.attr('placeholder'));
  }
}).blur();



/* -----------------------------
Screenshot Load
----------------------------- */
$(document).ready(function() {
	'use strict';
	$('.view-project').on('click', function(e) {
		e.preventDefault();

		var href 			= $(this).attr('href') + ' .portfolio-project',
			portfolioWrap	= $('.porfolio-container'),
			contentLoaded 	= $('#portfolio-load'),
			offset			= $('#section-screenshots').offset().top;

		portfolioWrap.animate({'left':'-120%'},{duration:300,queue:false});
		portfolioWrap.fadeOut(300);
		$('html, body').animate({scrollTop: offset},{duration:700,queue:true});
		setTimeout(function(){ $('#portfolio-loader').fadeIn('fast'); },200);

		setTimeout(function(){
            contentLoaded.load(href, function(){
                $('#portfolio-loader').fadeOut('fast');
                contentLoaded.fadeIn(500).animate({'left':'0'},{duration:700,queue:false});
                $('.back-button').fadeIn(500);
            });
        },300);



	});

	$('.backToProject').on('click', function(e){
		e.preventDefault();

		var portfolioWrap	= $('.porfolio-container'),
			contentLoaded 	= $('#portfolio-load');

		contentLoaded.animate({'left':'105%'},{duration:300,queue:false}).delay(200).fadeOut(300);
        $(this).parent().fadeOut(300);
		setTimeout(function(){
            portfolioWrap.animate({'left':'0'},{duration:300,queue:false});
            portfolioWrap.fadeIn(500);
        },500);

	});

});



/* -----------------------------
BxSlider
----------------------------- */
$(document).ready(function() {
	'use strict';
	$('.testimonial-slider').bxSlider({
		pagerCustom: '#bx-pager',
		pager: true,
		touchEnabled: true,
		controls: false
	});
});


/* -----------------------------
Main navigation
----------------------------- */
$(document).ready(function() {
	'use strict';
	$('.nav').onePageNav({
		currentClass: 'current',
		scrollSpeed: 1000,
		easing: 'easeInOutQuint'
	});
	$(window).bind('scroll', function(e) {
		var scrollPos = $(window).scrollTop();
		scrollPos > 220 ? $('.sticky-section').addClass('nav-bg') : $('.sticky-section').removeClass('nav-bg');
	});
});


/* -----------------------------
MailCimp Plugin Script
----------------------------- */
$(document).ready(function() {
	'use strict';
	$('#subscription-form').ajaxChimp({
		callback: mailchimpCallback,
		url: 'YOUR_URL' /* Replace it with your custom URL inside '' */
	});

	function mailchimpCallback(resp) {
		 if(resp.result === 'success') {
			$('.subscription-success')
				.html(resp.msg)
				.delay(500)
				.fadeIn(1000);

			$('.subscription-success').fadeOut(8000);

		} else if(resp.result === 'error') {
			$('.subscription-failed')
				.html(resp.msg)
				.delay(500)
				.fadeIn(1000);

			$('.subscription-failed').fadeOut(5000);
		}
		$('#subscription-form .input-email').val('');
	};
});



/* -----------------------------
Contact form
----------------------------- */
/*$(document).ready(function() {
	'use strict';
	$('form.contact-form').on('submit', function(e) {
		$.post('/register', $(this).serialize(), function(response) {
			if ($('.confirmation p').html() != "") {
				$('.confirmation p').replaceWith('<p><span class="fa fa-check"></span></p>');
			}
			$('.confirmation p').append(response).parent('.confirmation').show();
			$('html, body').animate({
				scrollTop: $('#section-contact').offset().top
				},{duration:800,queue:true});
			$('.form-item').val('');
			setTimeout(function() {
				$('.confirmation').hide();
			}, 8000);
		});

		// disable default action
		e.preventDefault();


	});*/

//});
			
