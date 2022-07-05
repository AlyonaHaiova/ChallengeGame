import { FC } from "react";
import { Link } from "react-router-dom";
import { app } from "../../meta/app";
import { pages } from "../../meta/page";
import "./Logo.scss";

const logo = require("./logo.png");

const Logo: FC = () => {
    return (
        <Link to={pages.home} className="Logo s-hflex full-height">
            <img src={logo} alt="logo" />
            <span className="s-vflex-center app-name">
                {app.name}
            </span>
        </Link>
    );
};

export default Logo;
