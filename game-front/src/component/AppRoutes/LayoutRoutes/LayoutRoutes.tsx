import { FC } from "react";
import { Route, Routes } from "react-router-dom";
import { pages } from "../../../meta/page";
import Navbar from "../../Navbar";
import HomePage from "../../page/home";
import LoginPage from "../../page/login";

const LayoutRoutes: FC = () => {
    return (
        <>
            <Navbar />
            <Routes>
                <Route path={pages.home} element={<HomePage />} />
                <Route path={pages.login} element={<LoginPage />} />
            </Routes>
        </>
    );
}

export default LayoutRoutes;
