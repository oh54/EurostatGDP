$(document).ready(function() {
	var countryColors = {
		"Albania" : "#e41e20",
		"Andorra" : "#fedf00",
		"Austria" : "#ed2939",
		"Belarus" : "#c8313e",
		"Belgium" : "#fae042",
		"Bosnia and Herzegovina" : "#002395",
		"Bulgaria" : "#00966e",
		"Croatia" : "#f00",
		"Cyprus" : "#d47600",
		"Czech Republic" : "#d7141a",
		"Denmark" : "#c60c30",
		"Estonia" : "#4891d9",
		"Finland" : "#003580",
		"France" : "#002395",
		"Germany" : "#ffce00",
		"Greece" : "#0d5eaf",
		"Hungary" : "#436f4d",
		"Iceland" : "#003897",
		"Ireland" : "#169b62",
		"Italy" : "#ce2b37",
		"Latvia" : "#9e3039",
		"Liechtenstein" : "#002b7f",
		"Lithuania" : "#006a44",
		"Luxembourg" : "#00a1de",
		"Malta" : "#cf142b",
		"Moldova" : "#ffd200",
		"Monaco" : "#ce1126",
		"Montenegro" : "#d3ae3b",
		"Netherlands" : "#ae1c28",
		"Norway" : "#ef2b2d",
		"Poland" : "#dc143c",
		"Portugal" : "#f00",
		"Republic of Macedonia" : "#d20000",
		"Romania" : "#fcd116",
		"San Marino" : "#5eb6e4",
		"Serbia" : "#c6363c",
		"Slovakia" : "#ee1c25",
		"Slovenia" : "#005da4",
		"Spain" : "#ffc400",
		"Sweden" : "#fecc00",
		"Switzerland" : "#f00",
		"Ukraine" : "#ffd500",
		"United Kingdom" : "#00247d",
		"Vatican City" : "#ffe000",
		"Euro area" : "#003399",
		"European Union" : "#003399"
	}

	var ctx = document.getElementById("myChart");
	function getCountryData(chart, countryCode) {
		return chart.data.datasets.find(function(countryObject) {
			return countryObject.code == countryCode;
		});
	}

	var datasets = [];
	var count = countries.length;
	for (var j = 0; j < count; j++) {
		datasets[j] = {
			label : countries[j].name,
			code : countries[j].code,
			hidden : true,
			fill : false,
			lineTension : 0.1,
			pointHighlightStroke : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			pointHighlightFill : "#fff",
			backgroundColor : countryColors[countries[j].name],
			borderColor : countryColors[countries[j].name],
			borderWidth : 5,
			borderCapStyle : 'butt',
			borderDash : [],
			borderDashOffset : 0.0,
			borderJoinStyle : 'miter',
			pointBorderColor : countryColors[countries[j].name],
			pointBackgroundColor : countryColors[countries[j].name],
			pointBorderWidth : 2,
			pointRadius : 3,
			pointHoverRadius : 4,
			pointHoverBackgroundColor : countryColors[countries[j].name],
			pointHoverBorderColor : "#333",
			pointHoverBorderWidth : 2,
			pointHitRadius : 1,
			pointStrokeColor : "#fff",
			pointHitRadius : 20,
			data : countries[j].values,
			spanGaps : false,
		}
	}

	var options = {
		responsive : true,
		maintainAspectRatio : false,
		legend : {
			display : false,
			labels : {
				boxWidth : 5
			}
		},
		title : {
			display : true,
			position : "top",
			text : chartLabel,
			fontSize : 20
		},
		hover : {
			mode : "label"
		},
		tooltips : {
			enabled : true,
			mode : "label",
			itemSort : function(a, b) {
				return parseFloat(b.yLabel) - parseFloat(a.yLabel);
			}
		},
		scales : {
			yAxes : [ {
				ticks : {
					display : true,
					suggestedMin : 0,
					beginAtZero : true
				},
				scaleLabel : {
					display : true,
					labelString : yLabel
				}
			} ],
		},
		legendCallback : function(chart) {
			var text = [];
			text.push('<ul>');
			for (var i = 0; i < chart.data.datasets.length; i++) {
				var countryLabel = chart.data.datasets[i].label;
				var countryCode = chart.data.datasets[i].code;
				text.push('<li class="col-md-12">');
				text.push('<input class="checkbox-custom" type="checkbox" name="countryCheck" id="' + countryCode + '"/>');
				text.push('<label class="checkbox-custom-label" for="' + countryCode + '">');
				text.push('<span style="background:' + countryColors[countryLabel] + '" class="label-before" id=' + countryCode + 'Span"></span>');
				text.push('<span><span></span></span>' + countryLabel + '</label>');
				text.push('</li>');
			}
			text.push('</ul>');
			return text.join("");
		}
	}

	var data = {
		labels : labels,
		datasets : datasets
	};

	var myLineChart = new Chart(ctx, {
		type : 'line',
		data : data,
		options : options
	});

	document.getElementById('js-legend').innerHTML = myLineChart.generateLegend();

	$("input[name=countryCheck").change(function() {
		var text = $("label[for=" + this.id + "]").text();
		var countryData = getCountryData(myLineChart, this.id);

		if ($(this).is(':checked')) {
			countryData.hidden = false;
		} else {
			countryData.hidden = true;
		}
		myLineChart.update();
	});
});

// myLineChart.data.datasets[0].data[2] = 50;
// myLineChart.update();
