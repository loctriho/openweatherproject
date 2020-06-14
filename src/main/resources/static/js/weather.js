$(document).ready(function() {
	$('#go').click(function(){
       if($('#searchname').val() == ''){
          alert('Input city name cannot be blank');
       }
       else{
            var cityname = $('#searchname').val();
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "/getData?city_name=" + cityname,
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					var current_date = new Date(data.timestamp * 1000);
					var sunset_date = new Date(data.sunset * 1000);
					var sunrise_date = new Date(data.sunrise * 1000);

					var result = "<h3> Data </h3>"
							+ "<strong>Temp: </strong> " + data.temperature + "<span> Celcius</span>" + "<br>"
							+ "<strong>Cloudiness: </strong>" + data.cloudiness + "<br>"
							+ "<strong>Pressure: </strong>" + data.pressure + "<span> hpa</span>" + "<br>"
							+ "<strong>Wind Speed: </strong>" + data.windSpeed + "<span> meters per second</span>" + "<br>"
							+ "<strong>Humidity: </strong>" + data.humidity + " <span>% </span>" + "<br>"
							+ "<strong>Timestamp: </strong>" + current_date + "<br>"
							+ "<strong>Sunset: </strong>" + sunset_date  + "<br>"
							+ "<strong>Sunrise: </strong>" + sunrise_date + "<br>"


					$("#ajax-response").html(result);
				},
				error : function(jqXHR, textStatus, errorThrown) {

				    var responseText = jQuery.parseJSON(jqXHR.responseText);

                        $("#errormessage").html(responseText.message);


				}
			});


       }

    });


})
