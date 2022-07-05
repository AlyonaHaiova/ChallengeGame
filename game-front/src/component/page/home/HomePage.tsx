import { FC } from "react";
import "./HomePage.scss";
import "../../../scss/common/flex.scss";

const HomePage: FC = () => {
    return (
        <div className="HomePage s-hflex-start m-vflex-center">
            <div>item 1</div>
            <div>item 2</div>
        </div>
    );
}

export default HomePage;
