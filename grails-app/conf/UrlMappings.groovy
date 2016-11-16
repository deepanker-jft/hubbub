class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(view:"/index")
        //"/"(view:"/home")
        "/"(controller: 'post',action: 'index')
     /*   "/"(controller: 'home',action: 'index')*/
        "500"(view:'/error')
	}
}
