	$(document).on('click', '#submitFrmNewOccurrence', function() {
		var url;
		var method = null;

		url = "occurrence/includeOccurrence";
		

		$.post(url, {
			occurrenceResponsible : $("#occurrenceResponsible").val(),
			"priorityBean.id" : $("#typesPriority").find(":selected").get(0).id
		});
	});