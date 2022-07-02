import { FC } from "react";
import { Route, Routes } from "react-router-dom";
import LayoutRoutes from "./LayoutRoutes";

const AppRoutes: FC = () => {
    return (
        <Routes>
            <Route path="/*" element={<LayoutRoutes />} />
        </Routes>
    );
}

export default AppRoutes;
