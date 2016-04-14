var dialogList = function(successCallback, errorCallback, title, list){
    
    cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'DialogList', // mapped to our native Java class called "CalendarPlugin"
            'dialog-list', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "title": title,
                "list": list
            }]
        ); 
}
module.exports = dialogList;
