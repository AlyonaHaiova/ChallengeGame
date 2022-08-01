import { FC } from "react";
import "./Navbar.css";
import ContentContainer from "../ContentContainer";
import Logo from "../Logo";
import NavbarActions from "../NavbarActions";

const Navbar: FC = () => {
    return (
        <div className="Navbar full-width">
            <ContentContainer>
                <div className="s-hflex full-height">
                    <Logo />
                    <div className="equal-flex" />
                    <NavbarActions />
                </div>
            </ContentContainer>
        </div>
    );
}

export default Navbar;
