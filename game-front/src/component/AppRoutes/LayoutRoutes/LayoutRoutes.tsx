import { FC } from "react";
import { Route, Routes } from "react-router-dom";
import { pages } from "../../../constant/page";
import HomePage from "../../page/home";
import LoginPage from "../../page/login";

const LayoutRoutes: FC = () => {
    return (
        <Routes>
            <Route path={pages.home} element={<HomePage />} />
            <Route path={pages.login} element={<LoginPage />} />
        </Routes>
    );
}

export default LayoutRoutes;
