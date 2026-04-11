import { Outlet } from "react-router-dom"
import NavBar from "../component/NavBar"

const Layout = () => {
  return (
    //<> é o Fragmento mas não precisa escrever
    <> 
        <NavBar />
      <div className="mx-20">
        <Outlet /> 
      </div>
  
    </>
    )
}
export default Layout