import { FC } from "react";
import "./HomePage.css";
import Input from "../../Input/Input";

const HomePage: FC = () => {
    return (
        <div className="HomePage s-hflex-start m-vflex-center">
            <div>item 1</div>
            <div>item 2</div>
            <Input name={"test"} placeholder={"test input"}></Input>
        </div>
    );
}

export default HomePage;
