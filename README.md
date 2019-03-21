# Lego
Individual school project

# UML
@startuml

Title Lego
namespace index.html { 
}

namespace main.jsp {
}

namespace register.jsp {
}

namespace login.jsp {
}


namespace shop.jsp { 
}

namespace view.jsp {
}

index.html --> main.jsp : choose legoshop
main.jsp --> register.jsp : if register
register.jsp --> login.jsp : login
main.jsp --> login.jsp : if login
login.jsp --> shop.jsp : valid login
login.jsp --> login.jsp : invalid login
shop.jsp --> view.jsp : view all orders
shop.jsp --> main.jsp : logout
view.jsp --> shop.jsp : order more
view.jsp --> main.jsp : logout

@enduml
