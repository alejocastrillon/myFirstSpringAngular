import { ParentEntity } from './parentEntity.model';
export class UserModel extends ParentEntity{
    public firstname: string;
    public secondname: string;
    public firstSurname: string;
    public secondSurname: string;
    public phone: string;
    public address: string;
}