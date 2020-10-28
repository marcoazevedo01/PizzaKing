function ajaxDoc(url, method) {
    return new Promise((resolve, reject) => {
        var jqXhr = $.ajax({
            url: `${url}`,
            crossDomain: true,
            async: true,
            contentType: 'json',
            type: `${method}`,
            xhrFields: {
                withCredentials: true
            }
        });
        jqXhr
            .done(function (data) {
                resolve(data);
            })
            .fail(function (xhr) {
                reject(xhr);
            });
    })
}