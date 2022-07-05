import { ReactNode } from "react";
import { Color } from "../../type/color";

export interface IShadowTextProps {
    children: ReactNode;
    className?: string;
    textColor?: Color;
    shadowColor?: Color;
}
