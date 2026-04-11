import { createBrowserRouter, Navigate } from "react-router-dom";
import Layout from "./Layout";
import CarrinhoPage from "../pages/CarrinhoPage";
import FavoritosPage from "../pages/FavoritosPage";
import HomePage from "../pages/HomePage";
import ListarProdutosPage from "../pages/ListarProdutosPage";
import CadastrarProdutosPage from "../pages/CadastrarProdutosPage";
import LoginPage from "../pages/LoginPage";
const router = createBrowserRouter([
    {
        //Primeiro objeto, rotas não protegidas, não precisa estar logado para acessar
         path: "/",
        element: <Layout />,
        children: [
            // A linha abaixo define a rota “índice” (a rota padrão) dentro do grupo de rotas
            // filhas do caminho /. Ou seja, quando o usuário acessa exatamente /, ela redireciona 
            // automaticamente para /home.
            // - index: true marca essa rota como a padrão do pai.
            // - <Navigate to="/home" replace /> faz o redirecionamento.
            // - replace troca a entrada no histórico (o usuário não volta para / ao apertar “voltar”).
            {index: true, element: <Navigate to="/home" replace />},
            {path: "home", element: <HomePage />},
            {path: "carrinho", element: <CarrinhoPage />},
            {path: "favoritos", element: <FavoritosPage />},
            {path: "listar-produtos", element: <ListarProdutosPage />},

            {path: "cadastrar-produto", element: <CadastrarProdutosPage />},
            {path: "login", element: <LoginPage />},
            // A página de erro já faz isso
            {path: "*", element: <h5 className="text-xl text-center mt-3">404 - Página não encontrada</h5>}]
    
        },
    {
        //Segundo objetos, rotas protegidas, precisa estar logado
    }
])
 //Objeto router, passamos um array de objetos
export default router;
