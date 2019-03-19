// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yaswanthi/Documents/casettaBE/conf/routes
// @DATE:Tue Mar 19 13:52:36 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:48
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:43
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:6
  class ReverseUsersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getCurrentUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/me")
    }
  
    // @LINE:6
    def registerUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:12
    def signOutUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signout")
    }
  
    // @LINE:10
    def signInUser(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/signin")
    }
  
  }

  // @LINE:41
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:45
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:28
  class ReverseImagesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def downloadImage(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "images/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:28
    def uploadImage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "images")
    }
  
    // @LINE:30
    def deleteImageByUrl(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "image")
    }
  
  }

  // @LINE:16
  class ReverseHotelController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def getHotelByUsername(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "hotels/username")
    }
  
    // @LINE:34
    def updateHotelById(id:Integer): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:16
    def createHotel(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "hotels")
    }
  
    // @LINE:33
    def getHotelById(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:18
    def searchHotels(location:String = null, maxP:Integer = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hotels" + play.core.routing.queryString(List(if(location == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("location", location)), if(maxP == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[Integer]].unbind("maxP", maxP)))))
    }
  
    // @LINE:35
    def deleteHotelById(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "hotels/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
  }


}
