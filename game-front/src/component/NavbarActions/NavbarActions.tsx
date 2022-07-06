import { FC } from "react";
import { Link } from "react-router-dom";
import { pages } from "../../meta/page";
import LanguageDropdown from "../LanguageDropdown";
import ShadowText from "../ShadowText";
import "./NavbarActions.scss";

const NavbarActions: FC = () => {
    return (
        <div className="NavbarActions s-vflex-center">
            <div className="s-hflex">
                <ShadowText className="text s-vflex-center">
                    <Link to={pages.login} className="link">
                        Login
                    </Link>
                </ShadowText>
                <ShadowText className="text s-vflex-center">
                    <Link to={pages.register} className="link">
                        Register
                    </Link>
                </ShadowText>
                <ShadowText className="s-vflex-center">
                    <Link to={pages.help} className="link">
                        <span className="material-icons s-vflex-center">question_mark</span>    
                    </Link>
                </ShadowText>
                <LanguageDropdown />
            </div>
        </div>
    );
}

export default NavbarActions;