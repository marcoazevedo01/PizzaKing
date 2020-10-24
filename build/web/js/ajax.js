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

var config = { attributes: true};
var target = document.querySelector('body');
var observer = new MutationObserver(function(mutations) {
    mutations.forEach(function(mutation) {
        if(mutation.target.classList.value == ''){
            window.location.reload()
        }
    });    
});
observer.observe(target, config);