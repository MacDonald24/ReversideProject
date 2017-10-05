'use strict';

/*
This module 
*/
angular.module('SampleApplication.Angular.Data', ['ngResource','angular-storage'])
	.controller('HomeController', ['$scope','$http','$location','store', function ($scope, $http,$location,store) {
                  console.log("Home Controller Start Here");
           var headerDetails = {headers: {'Content-Type': 'application/json'}};   
            $scope.loggedInAccount = store.get("account");
            store.set("loggedInAccount",$scope.loggedInAccount);
       console.log("--------------------");
        console.log("Logged In Account");
       console.log($scope.loggedInAccount);
     
        if($scope.loggedInAccount !== null) 
        {
            $http.get('/api/person/personId/'+ $scope.loggedInAccount.personId,headerDetails).then(function(res)
            {
              console.log("--------------------");
              console.log("Logged In Person");
              store.set("loggedInPerson",res.data);
              $scope.loggedInPerson = res.data;
              console.log($scope.loggedInPerson);
              console.log("--------------------");

            });
        }
            $scope.getChowNow = function()
            {
               $scope.searchAddress = window.globals.address;
                  console.log($scope.searchAddress);
                   console.log(window.globals.address);
               if($scope.searchAddress !== null)
               {
                   if(window.globals.address.formated_address !== null)
                   {
                       store.set("searchAddress",$scope.searchAddress);
                        $location.path("/viewRestaurant");
                   }
                   
               }
               
            };
            $scope.becomeDriver = function()
            {
                 $location.path("/driverReg");
            };
            $scope.becomePartner  = function()
            {
                  $location.path("/PartnerReg");
            } ;
            $scope.logout  = function()
            {
                  console.log("Please logout safely");
            } ;
        
                  console.log(window.globals.address); 
                  
          
            $http.get('api/person/person/'+ "Oarabile",headerDetails).then(function(res)
            {	
                console.log(res.data);
                        
            });

       }])
	.controller('RegisterController', ['$scope','$http','$location', function ($scope, $http ,$location) {

	   $scope.register = function()
	   {
		var address = {
                    "city": "",
                    "province": "",
                    "streetName": "",
                    "zipCode": ""
                };
                    var person =  {
                            "addresses": [address],
                            "alternateNumber": "",
                            "email":  $scope.email,
                            "firstName": $scope.name,
                            "gender": "",
                            "lastName": $scope.surname,
                            "mobileNumber": $scope.phone,
                            "password":  $scope.password
                          };
                    
                    console.log(person);

			$http.post('api/userAccount/post', person).then(function(res)
			{	
                            console.log(res.data);
                        
			});
                            $location.path("/signIn"); 
	   };
    }])


.controller('SignInController', ['$scope','$http','$location','store', function ($scope, $http,$location,store) {
    	
        var headerDetails = {headers: {'Content-Type': 'application/json'}};
	$scope.login = function()
	{
             var login = {
			"username" :  $scope.username,
			"password" :  $scope.pwd	
                        };
                $http.post('api/userAccount/session/login',login).then(function(res)
                {
                       //myservice.setOwnerInfo(res.data);
                       console.log(res.data);
                       store.set("account",res.data);
                     if(res.data.role === "Customer")
                     {
                          $location.path("/home");
                     }else if(res.data.role === "Admin")
                     {
                         $location.path("/AdminPortal");
                     }else if(res.data.role === "Partner")
                     {
                         $location.path("/PartnerPortal");
                     }
                                                   
                });	
	};
   
}])	

.controller('driverRegController', ['$scope','$http','$location' , function ($scope, $http,$location) {

        $scope.options = ["Alberton","Ballito","Bedfordview","Benoni","Bloemfontien","Bryanston","Centurion","Constatia","Crsta & Randburg","Durban North","East Rand Mall","Edenvale","Fordsburg","Fourways","Gardens","Gateway","Gordons Bay","Hatfield","Kempton Park","Kenilworkworth","kimberly","Klerksdorp","Melville","Menlyn","Midrand","Milnerton","Mthatha","Nelspruit","Northgate","Norwood","Parow","Polokwane","Port Elizabeth","Potchestroom","Rivonia & Sunninghill","Rondebosch","Rosebank","Rusternburg","Sandton","Sea Point","Somerset West","Southern Suburbs(JHB)","Stellenbosch","Table view","Tokai","Tygervalley","Weltevredepark","Westrand","Westvillie","Witbank","Other"];
        $scope.optionsTime = ["Anytime","Nights And Weekends","Weekends Only","Weekdays Only"];
        $scope.optionsPart = ["Full Time","Part Time","Others"];
        $scope.transportOption = ["Car","Bike","Other Transport"];
        $scope.names = ['Yes', 'No'];
        $scope.driverRequest = { favorite: 'Yes' };
       
        $scope.submitDriverForm = function(driverRequest)
        {
            
       
          var driverReq = {
                  "avaliabilty": driverRequest.availability,
                  "emailAddress": driverRequest.emailAddress,
                  "fullName": driverRequest.fullName,
                  "jobTime": driverRequest.hours,
                  "licenece": $scope.driverRequest.favorite,
                  "location": driverRequest.location,
                  "phoneNumber": driverRequest.phoneNumber,
                  "transport": driverRequest.transport
                };
                
                console.log(driverRequest);
                $http.post('api/driverRequest/post',driverReq).then(function(res)
                {
                    console.log(res.data);
                                                   
                });
        };
     
    }])	

.controller('partnerRegController', ['$scope','$http','$location' , function ($scope, $http,$location) {
                $scope.options = ["Alberton","Ballito","Bedfordview","Benoni","Bloemfontien","Bryanston","Centurion","Constatia","Crsta & Randburg","Durban North","East Rand Mall","Edenvale","Fordsburg","Fourways","Gardens","Gateway","Gordons Bay","Hatfield","Kempton Park","Kenilworkworth","kimberly","Klerksdorp","Melville","Menlyn","Midrand","Milnerton","Mthatha","Nelspruit","Northgate","Norwood","Parow","Polokwane","Port Elizabeth","Potchestroom","Rivonia & Sunninghill","Rondebosch","Rosebank","Rusternburg","Sandton","Sea Point","Somerset West","Southern Suburbs(JHB)","Stellenbosch","Table view","Tokai","Tygervalley","Weltevredepark","Westrand","Westvillie","Witbank","Other"];
        $scope.submitPartnerForm = function(partnerRequest)
        {
         
         var partnerReq =  {
                "additionalInfo": partnerRequest.additionalInfo,
                "emailAddres": partnerRequest.emailAddress,
                "fullName": partnerRequest.fullName,
                "location": partnerRequest.location,
                "phoneNumber": partnerRequest.phoneNumber,
                "restuarantName": partnerRequest.restaurant
                };
               $http.post('api/partnerRequest/post',partnerReq).then(function(res)
                {
                   console.log(res.data.additionalInfo);
                                                   
                });
        };
    }])	
 .controller('AdminController', ['$scope','$http','$location' , function ($scope, $http,$location) {
     var headerDetails = {headers: {'Content-Type': 'application/json'}};
        console.log("AdminController");
        
         $http.get('/api/person/all',headerDetails ).then(function(res)
         {
                    console.log(res.data);
                    $scope.people = res.data;                               
        });
        $http.get('/api/userAccount/userAccounts/all',headerDetails ).then(function(res)
         {
                    console.log(res.data);
                    $scope.userAccounts = res.data;  
                                                   
        });
        $http.get('/api/driverRequest/all',headerDetails ).then(function(res)
        {
                    console.log(res.data);
                     $scope.driverRequests = res.data;                                 
        });
        
        $http.get('/api/partnerRequest/all',headerDetails ).then(function(res)
        {
                    console.log(res.data);
                     $scope.partnerRequests = res.data; 
        });

        $http.get('/api/restaurant/all',headerDetails ).then(function(res)
        {
                    console.log(res.data);
                     $scope.restaurants = res.data;   
 
        });
         $http.get('/api/restaurant/menu/categories/all',headerDetails ).then(function(res)
        {
                    console.log(res.data);
                    $scope.categories = res.data;
                  
        });
        $http.get('/api/restaurant/items/all',headerDetails ).then(function(res)
        {
                    console.log(res.data);
                       
                       $scope.items = res.data;
                  
        });
        
        $http.get('/api/order/all',headerDetails ).then(function(res)
        {
                    console.log(res.data);
                       
                       $scope.orders = res.data;
                  
        });
        
        $scope.getPartnerRequest= function(partnerRequest)
        {
                var randomPassword = Math.floor(Math.random() * 99999999);
                console.log(partnerRequest);
                var splitFullName   = partnerRequest.fullName.split(" ");
                var firstName = splitFullName[0];
                var lastName = splitFullName[1];
             
                var partnerPerson = {
                            "email": partnerRequest.emailAddres,
                            "firstName": firstName,
                            "lastName": lastName ,
                            "mobileNumber": partnerRequest.phoneNumber,
                            "password": randomPassword
                       };
           
            console.log(partnerPerson);
            
        $http.post('/api/userAccount/partner/post',partnerPerson,headerDetails ).then(function(res)
        {
                       
        });
            
        };
        
       $scope.deletePerson = function(person) {
         console.log(person);
     
            $http.delete('/api/person/remove/' + person.id,headerDetails ).then(function(res)
            {
                console.log(res);               
            });
        };
        
        $scope.deleteUserAccount = function(userAccount) {
         console.log(userAccount);
     
            $http.delete('/api/userAccount/remove/' + userAccount.accountId,headerDetails ).then(function(res)
            {
                console.log(res);
                
                if(res.status === 200 && res.statusText === "OK")
                {
                            alert("Delete Username " + res.data.username);
                }
            });
        };
        $scope.deletePartnerRequest = function(partnerReq)
        {
            //DELETE /api/partnerRequest/remove/{id}
            console.log(partnerReq);
             $http.delete('/api/partnerRequest/remove/' + partnerReq.partnerRequestId,headerDetails ).then(function(res)
            {
                
                if(res.status === 200 && res.statusText === "OK")
                {
                            alert("Delete PartnerRequesr " + res.data.fullName);
                }
            });
            
        };
        
        $scope.deleteDriverRequest = function(driverRequest)
        {
            
            $http.delete('/api/driverRequest/remove/' + driverRequest.driverReq,headerDetails ).then(function(res)
            {
                
                if(res.status === 200 && res.statusText === "OK")
                {
                            alert("Delete PartnerRequesr " + res.data.fullName);
                }
            });
            
        };
        
        $scope.getdriverRequest = function(driverRequest)
        {
              console.log(driverRequest);
             var randomPassword = Math.floor(Math.random() * 99999999);
                var splitFullName   = driverRequest.fullName.split(" ");
                var firstName = splitFullName[0];
                var lastName = splitFullName[1];
             
                var driverPerson = {
                            "email": driverRequest.emailAddress,
                            "firstName": firstName,
                            "lastName": lastName ,
                            "mobileNumber": driverRequest.phoneNumber,
                            "password": randomPassword
                       };
           
            console.log(driverPerson);
            $http.post('/api/userAccount/driver/post',driverPerson,headerDetails ).then(function(res)
            {
                         if(res.status === 200 && res.statusText === "OK")
                    {
                                alert("Driver Account " + res.data.username);
                    }   
            });
        };
        
        $scope.deleteRestaurant = function(rest)
        {
            console.log(rest);
            //DELETE /api/restaurant/remove/{restaurantId}
             $http.delete('/api/restaurant/remove/'+rest.restaurantId,headerDetails ).then(function(res)
            {
                         if(res.status === 200 && res.statusText === "OK")
                    {
                                console.log(res.data);
                    }   
            });
        };
            
  }])	
   .controller("PartnerController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("Parter Controller Start Here");
        $scope.categories = [];
          var personId = store.get("account").personId;
          console.log(store.get("account"));
          var headerDetails = {headers: {'Content-Type': 'application/json'}};
           $http.get('/api/person/personId/'+ personId,headerDetails).then(function(res)
           {  
                 $scope.partnerInfo = res.data; 
                 console.log($scope.partnerInfo);

           });
 
     
        var imageCopy = null;
        var image = null;
        var handleImageSelect = function(evt) {
        var files = evt.target.files;
        var file = files[0];

            if (files && file) {
                var reader = new FileReader();
                    reader.onload = function(readerEvt) {
                        var binaryString = readerEvt.target.result;
                        imageCopy = btoa(binaryString);
                        image = 'data:image/octet-stream;base64,'+ imageCopy;       
                        console.log(image);
                    };

                 reader.readAsBinaryString(file);	
            }
        };

        if (window.File && window.FileReader && window.FileList && window.Blob) {
           document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
        } else {
           alert('The File APIs are not fully supported in this browser.');
       }
        
        $scope.addRestaurant = function()
        {
              var restaurant = {
                        "accountId": store.get("account").accountId,
                        "address": window.globals.address.formated_address,
                        "image": image,
                        "name": $scope.restaurantName
                        };
                        
                   console.log(restaurant);     
           $http.post('/api/restaurant/post',restaurant).then(function(res)
           {
                 store.set("restId",res.data.restaurantId);
           });
        };
         $http.get('/api/restaurant/get/'+ store.get("account").accountId ,headerDetails).then(function(res)
         {
             console.log(res.data.categoryId);
             
            if(res.status === 200) 
            {
                if(res.data.categoryId !== null)
                {
                       for (var i = 0; i < res.data.categoryId.length; i++) {

                          if(res.data.categoryId[i] !== null)
                          {
                             console.log(res.data.categoryId[i]);
                               $http.get('/api/restaurant/category/'+ res.data.categoryId[i].categoryId,headerDetails).then(function(res)
                               {   
                                   $scope.categories.push(res.data);

                               });
                          }
                      }

                }else
                {
                    console.log("CategoryId null");
                };
            }

         });
         
            console.log($scope.lists);
        $scope.addCategory = function()
        {
           console.log("Enter Category Name " + $scope.categoryName +  "for restaurnat Id" + $scope.restId); 
                          
                    $http.get('/api/restaurant/get/'+ store.get("account").accountId ,headerDetails).then(function(res)
                    {
                        
                         var category = {
                        "name": $scope.categoryName,
                        "restaurantId":   res.data.restaurantId
                            };
                            store.set("restId",res.data.restaurantId);
                        $http.post('/api/restaurant/menu/category',category).then(function(res)
                        {
                               console.log(store.get("account").accountId)
                            $http.post('/api/restaurant/addCategories/'+ store.get("account").accountId,res.data).then(function(res)
                           {
                                  console.log(res.data);
                           });
                        });
                     });
        };

         $scope.addItem= function()
        {
           console.log("Enter Item Info" + $scope.category.categoryId); 
           var item = {
                "categoryId" : $scope.category.categoryId,
                "name": $scope.itemName,
                "price": $scope.itemPrice,
                "shortDescription": $scope.itemDescription
            };
         
            $http.post('/api/restaurant/category/item',item).then(function(res)
            {
                console.log(res.data);
                 $http.post('/api/restaurant/addItems/'+ $scope.category.categoryId,res.data).then(function(res)
                {
                    console.log(res.data);
                });
                
            });
        };
        
        
        
         
   }])
     .controller("UpdateProfileController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("Update ProfileController Start Here");
        
        var headerDetails = {headers: {'Content-Type': 'application/json'}};
        $scope.personInfo = store.get("loggedInPerson");
        console.log($scope.personInfo);
        $scope.names = ['Male', 'Female'];
        $scope.gender = { favorite: 'Yes' };
        
        $scope.profileFirstName = $scope.personInfo.firstName;
         $scope.profileLastName = $scope.personInfo.lastName;
          $scope.profilePhoneNumber = $scope.personInfo.mobileNumber;
          
          
          $scope.edit = function()
          {
              console.log("edit");
             
                        var editProfile = {
                                    "alternateNumber": $scope.profileAlternateNumber,
                                    "firstName": $scope.profileFirstName,
                                    "gender": $scope.gender.favorite,
                                    "id": $scope.personInfo.id,
                                    "lastName": $scope.profileLastName,
                                    "mobileNumber": $scope.profilePhoneNumber
                                };
                                
               console.log(editProfile);
               //POST /
                $http.post('api/person/edit',editProfile).then(function(res)
                {
                    if(res.data !== null)
                    {
                        store.set("editedProfile",res.data); 
                    }
                                  
                });
          };
      
   }])
        .controller("UpdateEmailAndPasswordController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("Update Email And Password Controller Start Here");
        
             $scope.accountInfo = store.get("loggedInAccount");
            console.log($scope.accountInfo);
            $scope.updateEmail = $scope.accountInfo.username;
            $scope.updatePassword = $scope.accountInfo.password;
            $scope.updateEmailAndPassword = function()
            {
                var updateAccount = {
                                        "accountId": $scope.accountInfo.accountId,
                                        "password": $scope.accountInfo.password,
                                        "personId":  $scope.accountInfo.personId,
                                        "username": $scope.updateEmail 
                                    };
                                    
                                    
                 console.log(updateAccount);
                //POST /api/userAccount/update
                $http.post('api/userAccount/update',updateAccount).then(function(res)
                {
                    if(res.data !== null)
                    {
                        store.set("updateAccount",res.data); 
                    }
                                  
                });
            };
   }])
         .controller("forgotPasswordController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("OrderHistory Controller Start Here");
        
            $scope.sendEmail = function()
            {
                console.log("Send Email to " + $scope.userEmail);
            };
   }])

          .controller("sendforgotEmailController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("OrderHistory Controller Start Here");
        
      
   }])
       .controller("orderHistoryController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("OrderHistory Controller Start Here");
        $scope.hideTable = false;
       $scope.hideTable = true;
        $scope.loggedInAccount = store.get("account");
        var headerDetails = {headers: {'Content-Type': 'application/json'}};
                
            $http.get('/api/order/customer/'+ $scope.loggedInAccount.personId ,headerDetails ).then(function(res)
            {
                console.log(res.data.length);
                if(res.data.length <=0)
                {
                  $scope.innerMessage = false;
                    $scope.hideTable = true;
                }else if(res.data.length  > 0)
                {
                    $scope.hideTable = false;
                   $scope.innerMessage = true;
                    $scope.historyOrders = res.data;
                }
                   
                   
                   
                                  
           });
        $scope.placeOrderNow = function()
        {
            console.log("I work man");
            $location.path("#/home");
        };
     }])
    .controller("FAQsController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("FAQs Controller Start Here");
        
      
        
   }])
   .controller("termsAndConditionsController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("Terms And Conditions Controller Controller Start Here");
        
      
         
   }])
      .controller("viewRestaurantController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("view Restaurants");
        
          $scope.customerAddress =  store.get("searchAddress");
          var address = $scope.customerAddress.formated_address.split(",");
          console.log(address);
          $scope.streetName = address[0];
          $scope.city = address[2];
          console.log($scope.streetName  +  " "  + $scope.city);
          $scope.changeAddress = function()
          {
              $location.path("/home");
          };
          
          
          $http.get('/api/restaurant/all').then(function(res)
           {
                console.log(res)
               $scope.restaurants = res.data;
                                  
           });
           
            $scope.showMenu = function(restaurant)
            {
                $location.path("/menu");
                store.set("restaurantInfo",restaurant);
            };
            
           
             
   }])
         .controller("menuController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
            console.log("view Restaurants menu");
            var headerDetails = {headers: {'Content-Type': 'application/json'}};
           $scope.restaurantInfo = store.get("restaurantInfo");
           
           $scope.categoriesInfo = [];
           $scope.itemsInfo = [];
           $scope.toCartItems = [];
           
            if($scope.restaurantInfo.categoryId !== null)
            {
                    for (var i = 0; i < $scope.restaurantInfo.categoryId.length; i++) {

                       if($scope.restaurantInfo.categoryId[i] !== null)
                       {
                            $http.get('/api/restaurant/category/'+ $scope.restaurantInfo.categoryId[i].categoryId,headerDetails).then(function(res)
                            {   
                                 $scope.categoriesInfo.push(res.data);
                                 if(res.data.items !== null)
                                 {
                                     if (res.data.items.length !== 0)
                                     {
                                         $scope.itemsInfo.push(res.data.items);
                                     }
                                 }
                            });
                       }
                   }  
            }
           $scope.addItemToCart = function(item)
           {
               console.log(item);
                 $scope.item  = item;
           };
           
           $scope.quantity = 0;
           $scope.ItemToPrice = 0.0;
           
           $scope.increase = function()
           {

                if($scope.quantity >= 0)
                {
                    $scope.quantity += 1;
                    
                    $scope.ItemToPrice = $scope.item.price * $scope.quantity;
                    store.set("toCartItems",$scope.toCartItems);
                   
                }
           };
            $scope.decrease = function()
           {
               if($scope.quantity > 0)
                {
                    $scope.quantity -= 1;
                }
              
           };
           
           $scope.displayGoToCart = function()
           {
               console.log("display Go To Cart");
              var cartItem = {
                   "categoryId": $scope.item.categoryId,
                   "itemId": $scope.item.itemId,
                   "name": $scope.item.name,
                   "price":$scope.item.price,
                   "quantity": $scope.quantity,
                   "shortDescription": $scope.item.shortDescription
                 };
                 if(cartItem !== null)
                 {
                     console.log(cartItem);
                     $scope.quantity = 0.0;
                 }

                $http.post('/api/shoppingCart/addItem',cartItem).then(function(res)
                {
             
                    store.set("itemsInCart",res.data);
                });
           };
           
           $scope.goToCart = function()
           {
               $location.path("/goToCart");
           };
            
   }])
        .controller("shoppingCartController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
   
            var headerDetails = {headers: {'Content-Type': 'application/json'}};
            $scope.names = ['Mr D Delivery', 'Self Collect'];
            $scope.collection = { favorite: 'Mr D Delivery' };
            $scope.estatimatedTime = null;
            $scope.subtotal = 0.0;
            $scope.total = 0.0;
            $scope.chart = store.get("itemsInCart");
            var orginal_amount = 0.0;
             
    
            $scope.collection.favorite === 'Mr D Delivery';
            $scope.estatimatedTime = "Estimated time of delivery 45 minutes"; 
           for(var v = 0 ; v < $scope.chart.length ; v++)
           {
              $scope.subtotal += $scope.chart[v].price  * $scope.chart[v].quantity;

           }
            $scope.deliveryFee = 20.00;
            $scope.decision = "Mr D Delivery";
            $scope.total +=  $scope.deliveryFee +  $scope.subtotal;

            $scope.estimanate = function()
            {
                 console.log($scope.collection.favorite);
                 
                 if($scope.collection.favorite === 'Mr D Delivery')
                 {
                        $scope.estatimatedTime = "Estimated time of delivery 45 minutes"; 
                        $scope.serviceFee = false;
                        $scope.decision = "Mr D Delivery";
                        $scope.total =  $scope.subtotal + $scope.deliveryFee;
                 }else if($scope.collection.favorite === 'Self Collect')
                 {
                        $scope.serviceFee = true;
                        $scope.estatimatedTime = " Ready to collect in 20 minutes";
                        $scope.total =  $scope.subtotal;
                        $scope.decision = "Self Collect";
                 }
                 
                 console.log($scope.estatimatedTime);
            };
        
            $scope.incroment = function(option,c)
            {
                
                 console.log(orginal_amount);
                 var chwPrice = 0.0;
               
                if(option === "down")
                {
                   
                    if(c.quantity > 1  )
                    {
                       console.log(c.quantity);
                       c.quantity -= 1; 
                       chwPrice =  c.price * c.quantity;
                        console.log(  chwPrice );
                    }
                   /* subtotal -= chwPrice;
                    console.log(subtotal +" "+ "subtotal");
                 
                    total -=chwPrice;
                   console.log(total +" "+ "total");*/
                       $scope.subtotal -= c.price;
                  $scope.total -= c.price;
                     
                }else if(option === "up")
                {
                    if(c.quantity >= 1)
                    {
                        c.quantity += 1;
                        chwPrice =  c.price * c.quantity;
               
                    }
                           $scope.subtotal += c.price;
                            $scope.total += c.price;
                  
                    /*subtotal += chwPrice;   console.log(subtotal);
              
                    total += chwPrice;
                    console.log(total);*/
 
                }
               //$scope.subtotal += orginal_amount;
                      
            };
            
            $scope.removeItem = function(item)
            {
                console.log("Remove Button");
                console.log(item.itemId);
                 $scope.total = $scope.subtotal - item.price * item.quantity; 
                 $scope.subtotal -= item.price * item.quantity; 
                        var index = $scope.chart.indexOf(item);
                        console.log(index + " index");   
                        $scope.chart.splice(index, 1);  
                 console.log($scope.chart);
                /*$http.get('/api/shoppingCart/removeItem/'+ item.itemId,headerDetails).then(function(res)
                 {
                        console.log(res.data);
                        
                 });*/
                
             
            };
           
            $scope.continue= function()
            {
                console.log($scope.chart.length);
                if($scope.chart !== null);
                {
                    store.set("decision",$scope.decision);
                    store.set("subtotal",$scope.subtotal);
                    store.set("serviceFee",$scope.deliveryFee);
                    store.set("total",$scope.total);
                    store.set("ItemsInTheCart",$scope.chart);
                    $location.path("/reviewOrderDetails");
                    
                }
                
                  
            };
     
   }])
  .controller("reviewOrderDetailController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) { 
        console.log("Review Order Details");
            var headerDetails = {headers: {'Content-Type': 'application/json'}};
        var formated_address =  store.get("searchAddress").formated_address;
      $scope.myCart = store.get("ItemsInTheCart");
      console.log($scope.myCart);
      var address =  formated_address.split(",") ;
      
          $scope.address1 =  address[0];
      $scope.address2 = address[1];
      $scope.address3 = address[2];
      $scope.address4 = address[3];
      $scope.address5 = address[4];
      
      $scope.places = ["Apartment" , "House" , "Office" ,"Hotel / B&B"];
      $scope.payments = ["Credit Card","Cash on Delivery"];
      $scope.customerPayment = { favorite: 'Credit Card' };
      $scope.tips = ["No Tip","10%","15%","20%"];
      $scope.customerTips = { favorite: 'No Tip' };
      
      $scope.foodTotal = store.get("subtotal");
      $scope.serviceFee = store.get("serviceFee");
      $scope.total = store.get("total");
       $scope.flowTip = 0.0;
      
      
      $scope.buttonName = "Contine to Card Payment";
      $scope.tipMessage = "100% of the tip goes to the waiter";
      $scope.waiterTip = false;
      $scope.typePayment = 'Credit Card';
      $scope.paymentSelection = false;
      $scope.giveWaiterTip = true;
      if(store.get("decision") === -"Self Collect")
      {
          console.log(store.get("decision"));
          $scope.serviceFeeDisplay = true;
          $scope.waiterTip = true;
          $scope.paymentSelection = true;
        
          $scope.paymentMessage = "Credit Card Only for collect orders";
      }else if(store.get("decision") === "Mr D Delivery")
      {
          $scope.paymentSelection = false;
          $scope.paymentMessage = "Please note, cash payment is not available for self-collect orders";
           console.log(store.get("decision"));
        $scope.paymentType = function(paymentType)
        {
             console.log(paymentType);
             
           if(paymentType === 'Credit Card')
           {
               $scope.typePayment = paymentType;
                $scope.buttonName = "Contine to Card Payment";
                $scope.waiterTip = false;
                        
            }else if(paymentType === 'Cash on Delivery')
            {        
                $scope.typePayment = paymentType;
                $scope.buttonName = "Contine to Cash Payment";
                $scope.waiterTip = true;
                
            }
            
        }; 
      }

        $scope.generatedOrderNumber = "MRD" + Math.floor(Math.random()*8999999+1000000);
        console.log($scope.generatedOrderNumber);
        store.set("orderNumber",$scope.generatedOrderNumber);
        $scope.buildingTypeSpecific = true;
        $scope.show = function()
        {
            
            
            if($scope.gae === "Apartment")
            {
                $scope.buildingTypeSpecific = false;
                $scope.buidingTypeMessage = "Unit no & complex number...";
               
            }else if($scope.gae === "Office")
            {
                $scope.buildingTypeSpecific = false;
                $scope.buidingTypeMessage = "Floor no & building name";
            }else if($scope.gae === "Hotel / B&B")
            {
                $scope.buildingTypeSpecific = false;
                $scope.buidingTypeMessage = "Room no & hotel name";
            }
        };
        $scope.tipTake = function(theTip)
          {
  
              if(theTip === "No Tip")
              {
                   $scope.giveWaiterTip = true;
                     $scope.flowTip = $scope.total * 0/100;
              }else if(theTip === "10%")
              {
                  $scope.flowTip = $scope.total * 10/100;
                  console.log($scope.flowTip);
                  $scope.giveWaiterTip = false;
              }else if(theTip === "15%")
              {
                  $scope.flowTip = $scope.total * 15/100;
                    console.log($scope.flowTip);
                   $scope.giveWaiterTip = false;
              }else if(theTip === "20%")
              {
                  $scope.flowTip = $scope.total * 20/100;
                   console.log($scope.flowTip);
                   $scope.giveWaiterTip = false;
              }
              
       
          };
        $scope.saveAddress = function()
        {
            console.log("save address");
        };
        
        var personDetail = store.get("account");
        

        $http.get('/api/person/personId/'+ personDetail.personId,headerDetails).then(function(res)
        {
            $scope.personDetail = res.data;
        });

        $scope.selectedRestaurant = store.get("restaurantInfo"); 
           
          $scope.moveToPayment = function()
          {
                var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!
        var yyyy = today.getFullYear();

        if(dd<10) {
        dd = '0'+dd;
        } 

        if(mm<10) {
            mm = '0'+mm;
        } 

        today = mm + '/' + dd + '/' + yyyy;
        console.log(today);
                var toAddress = $scope.address1 + ", "+ $scope.address2 + ", "+ $scope.address3 + ", "+ $scope.address4 + ", "+ $scope.address5 ;
                console.log( $scope.personDetail);
                var reviewOrderDetails = {
                    
                    "orderNumber" : $scope.generatedOrderNumber,
                    "buildingType" : $scope.gae,
                    "buildingTypeSpecific" :$scope.buildingTypeSpec,
                    "toAddress" :  toAddress, 
                    "restaurantName" : $scope.selectedRestaurant.name,
                    "deliveryInstruction" : $scope.deliveryInstruction,
                    "paymentMethod" : $scope.typePayment,
                    "foodTotal" : $scope.foodTotal,
                    "serviceFee" : $scope.serviceFee,
                    "total" : $scope.total +  $scope.flowTip,
                    "items" : $scope.myCart,
                    "date" : today,
                    "personId" : $scope.personDetail.id,
                    "status" : "Incomplete"
                    
                };
                
                
                console.log(reviewOrderDetails);
                
       
                
                store.set("reviewOrderDetails",reviewOrderDetails);
                if($scope.typePayment === "Credit Card" )
                {
                    
                    $location.path("/creditCardPayment"); 
                    
                }else if( $scope.typePayment === "Cash on Delivery")
                {
                   
                    $location.path("/cashPayment");
                }
          };
            
          

   }])
   
   .controller("creditCardPaymentController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) 
   {
       var headerDetails = {headers: {'Content-Type': 'application/json'}};
       console.log("credit Card Payment");
       $scope.reviewOrderDetails = store.get("reviewOrderDetails");
       console.log($scope.reviewOrderDetails);
       
       $scope.payWithCard = function()
       {
                console.log($scope.cardholderName );
                console.log($scope.cardNumber);
                console.log($scope.cardExpiryMonth);
                console.log($scope.cardExpiryYear);
                console.log($scope.cardSecurityCode);
                
                var testOrder = {
                          
                            "buildingType": $scope.reviewOrderDetails.buildingType,
                            "buildingTypeSpecific": $scope.reviewOrderDetails.buildingTypeSpecific,
                            "deliveryInstruction": $scope.reviewOrderDetails.deliveryInstruction,
                            "foodTotal":$scope.reviewOrderDetails.foodTotal,
                            "restaurantName": $scope.reviewOrderDetails.restaurantName,
                            "items":$scope.reviewOrderDetails.items,
                            "orderNum": $scope.reviewOrderDetails.orderNumber,
                            "paymentMethod": $scope.reviewOrderDetails.paymentMethod,
                            "personId": $scope.reviewOrderDetails.personId,
                            "serviceFee": $scope.reviewOrderDetails.serviceFee,
                            "status": "Incomplete",
                            "toAddress": $scope.reviewOrderDetails.toAddress,
                            "total": $scope.reviewOrderDetails.total,
                            "date" :$scope.reviewOrderDetails.date
                        };
                        $http.post('api/order/post',testOrder).then(function(res)
                        {
                            console.log(res.data);
                            if(res.data !== null)
                            {
                                $scope.orderDetails = res.data;
                                $http.get('/api/person/personId/'+ res.data.personId).then(function(res)
                                {
                                         if(res.data !== null)
                                         {
                                               var creditCardPayment = {
                                                   
                                                    "customSurname": res.data.lastName,
                                                    "customerId": res.data.id,
                                                    "customerName": res.data.firstName,
                                                    "orderId": $scope.orderDetails.id ,
                                                    "transactionType": $scope.orderDetails.paymentMethod
                                                };
                                                console.log(creditCardPayment);
                                                $http.post('/api/payment/post',creditCardPayment,headerDetails ).then(function(res)
                                                {
                                                    console.log(res);
                                                });
   
                                         };
                                });
 
                            };
                        });
        
       };
 
       
    }])

  .controller("cashPaymentController", ['$scope','$http','$location','store', function ($scope, $http,$location,store) 
   {
                      var headerDetails = {headers: {'Content-Type': 'application/json'}};
                  $scope.reviewOrderDetails = store.get("reviewOrderDetails");
                  console.log($scope.reviewOrderDetails);
           
                  $scope.confirmCashOrder = function()
                  {
                         var testOrder = {
                          
                            "buildingType": $scope.reviewOrderDetails.buildingType,
                            "buildingTypeSpecific": $scope.reviewOrderDetails.buildingTypeSpecific,
                            "deliveryInstruction": $scope.reviewOrderDetails.deliveryInstruction,
                            "foodTotal":$scope.reviewOrderDetails.foodTotal,
                            "restaurantName": $scope.reviewOrderDetails.restaurantName,
                            "items":$scope.reviewOrderDetails.items,
                            "orderNum": $scope.reviewOrderDetails.orderNumber,
                            "paymentMethod": $scope.reviewOrderDetails.paymentMethod,
                            "personId": $scope.reviewOrderDetails.personId,
                            "serviceFee": $scope.reviewOrderDetails.serviceFee,
                            "status": "Incomplete",
                            "toAddress": $scope.reviewOrderDetails.toAddress,
                            "total": $scope.reviewOrderDetails.total,
                            "date" :$scope.reviewOrderDetails.date
                        };
                        $http.post('api/order/post',testOrder).then(function(res)
                        {
                            console.log(res.data);
                            if(res.data !== null)
                            {
                                $scope.orderDetails = res.data;
                                $http.get('/api/person/personId/'+ res.data.personId).then(function(res)
                                {
                                         if(res.data !== null)
                                         {
                                               var cashPayment = {
                                                   
                                                    "customSurname": res.data.lastName,
                                                    "customerId": res.data.id,
                                                    "customerName": res.data.firstName,
                                                    "orderId": $scope.orderDetails.id ,
                                                    "transactionType": $scope.orderDetails.paymentMethod
                                                };
                                                console.log(cashPayment);
                                                $http.post('/api/payment/post',cashPayment,headerDetails ).then(function(res)
                                                {
                                                    console.log(res);
                                                });
   
                                         };
                                });
 
                            };
                        });
                  };
    }]);
        
   
   

    

